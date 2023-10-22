package com.example.restapi.services.conge;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.exceptions.CongeException;
import com.example.restapi.model.conge.CongeConsomme;
import com.example.restapi.model.conge.DemandeConge;
import com.example.restapi.model.conge.DemandeCongeDAO;
import com.example.restapi.model.conge.EtatConge;
import com.example.restapi.model.conge.TypeConge;
import com.example.restapi.model.employe.Employe;
import com.example.restapi.repositories.EmployeRepository;
import com.example.restapi.repositories.conge.CongeConsommeRepository;
import com.example.restapi.repositories.conge.CongeRepository;
import com.example.restapi.repositories.conge.EtatCongeRepository;
import com.example.restapi.repositories.conge.TypeCongeRepository;
import com.example.restapi.services.EmployeService;

import jakarta.transaction.Transactional;

@Service
public class CongeService {
    @Autowired
    EmployeRepository empRepository;
    @Autowired
    CongeConsommeRepository consommeRepo;
    @Autowired
    CongeRepository congeRepo;
    @Autowired
    private EmployeService employeService;
    @Autowired
    EtatCongeRepository etatCongeRepo;
    @Autowired
    TypeCongeRepository typeCongeRepo;

    public List<DemandeConge> findAll() {
        return this.congeRepo.findAll();
    }

    // tokony zay RH ihany afaka miantso an'ito
    public List<DemandeCongeDAO> findValideConge() {
        List<DemandeCongeDAO> demandes = new ArrayList<DemandeCongeDAO>();
        this.congeRepo.findByStatus(5).stream().forEach((d) -> {
            demandes.add(new DemandeCongeDAO(d));
        });
        return demandes;
    }

    public List<TypeConge> findTypeConges() {
        return this.typeCongeRepo.findAll();
    }

    public Optional<TypeConge> findTypeCongeById(int id) {
        return this.typeCongeRepo.findById(id);
    }

    public HashMap<String, Object> findConge() throws Exception {
        HashMap<String, Object> res = new HashMap<String, Object>();
        List<DemandeCongeDAO> demandes = new ArrayList<DemandeCongeDAO>();
        this.findByAuthenticatedEmp().stream().forEach((d) -> {
            demandes.add(new DemandeCongeDAO(d));
        });
        Employe e = this.employeService.getAuthenticatedEmploye();
        EtatConge etat = findEtatConge(e.getId());
        res.put("etat", etat);
        res.put("conge", demandes);
        return res;
    }

    public EtatConge findEtatConge(int idEmp) throws Exception {
        return this.etatCongeRepo.findById(idEmp).orElseThrow(() -> new Exception("Etat de congé introuvable"));
    }

    public List<DemandeConge> findByAuthenticatedEmp() throws Exception {
        // Ovaina an'ilay get AuthenticatedEmp any am Nante
        Employe emp = this.employeService.getAuthenticatedEmploye();
        return this.congeRepo.findByEmp(emp);
    }

    @Transactional(rollbackOn = { Exception.class })
    public void acceptDemande(int id) throws Exception {
        DemandeConge demande = this.congeRepo.findById(id)
                .orElseThrow(() -> new Exception("Demande de congé introuvable"));
        Employe empConn = this.employeService.getAuthenticatedEmploye();
        if (empConn.getId() == this.empRepository.getIdChef(empConn.getService().getId())) {
            this.congeRepo.updateStatus(id, 5);
            if (demande.getType().isDeductible()) {
                double duree = demande.getDuree();
                System.out.println(" deductible  avec durée " + duree + "=====================");
                CongeConsomme exist = this.consommeRepo.findByIdEmploye(demande.getEmp().getId())
                        .orElse(new CongeConsomme(demande.getEmp().getId()));
                exist.setJour(exist.getJour() + duree);
                // CongeConsomme c = new CongeConsomme(demande.getEmp().getId(), duree);
                this.consommeRepo.save(exist);
            }
        } else {
            throw new Exception("Permission refuse, Vous n'etes pas habilite a faire cette action");
        }
    }

    @Transactional(rollbackOn = { Exception.class })
    public void refuseDemande(int id) throws Exception {
        DemandeConge demande = this.congeRepo.findById(id)
                .orElseThrow(() -> new Exception("Demande de congé introuvable"));
        this.congeRepo.updateStatus(id, -5);
    }

    public boolean checkDemandeConge(DemandeCongeDAO demandeConge) throws Exception {
        // 🤣 Jereo koa l'ty hoe datefin after datedebut ah
        // Alaina aloha ilay DemandeConge
        // Alaina ny emp an'ilay DemandeConge, ovaina getter an'i Employe zany ito
        Employe emp = this.employeService.getAuthenticatedEmploye();
        TypeConge typeConge = this.findTypeCongeById(demandeConge.getType().getId())
                .orElseThrow(() -> new Exception("Type conge invalide"));
        // if(DemandeConge.TypeConge.deductible == false) => return true else
        if (!typeConge.getGenre().equals("*")
                && !typeConge.getGenre().equals(String.valueOf(emp.getUtilisateur().getGenre().getId()))) {
            throw new CongeException("Ce congé n'est pas pour les " + emp.getUtilisateur().getGenre().getNom());
        }

        if (typeConge.isDeductible() == false) {
            return true;
        }

        int nbrJourDemande = (int) ChronoUnit.DAYS.between(demandeConge.getDebut(), demandeConge.getFin()) + 1;
        // Demandeconge.fin-DemandeConge.debut
        // d eto koa hoe ahoana raha 1 jour lay izy? genre 2023-10-22 jusqu'à 2023-10-22
        // ? raha atao ftsn manko différence en jour d lasa 0 io zany hoe lay
        // Demandeconge.fin-DemandeConge.debut zany mila atao +1,je pense 😶‍🌫️
        // int nbr = 2;
        int rest = this.getResteConge(emp.getId());
        // si demandeconget.type.genre != '*' et != demandeConge.emp.genre.id =>
        // throw Exception
        if (rest < nbrJourDemande) {
            throw new CongeException("Nombre de congé restant insuffisant");
        }
        if (emp.getContrat().getAnciennete().getYears() < 1) {
            throw new CongeException("Ancienneté inférieure à 1 an.");
        }
        return true;
    }

    public int getResteConge(int id) {
        return this.empRepository.getRestConge(id);
    }

    public void findAllDemandeUnder(int categorieValeur) {
        this.congeRepo.findAllDemandeCongeUnder(categorieValeur);
    }

    public List<DemandeCongeDAO> findAllValideCongeUnder() throws Exception {
        Employe emp = this.employeService.getAuthenticatedEmploye();
        List<DemandeCongeDAO> res = new ArrayList<DemandeCongeDAO>();
        List<DemandeConge> demandes = this.congeRepo
                .findAllValideCongeUnder(emp.getContrat().getCategorie().getValeur());
        demandes = demandes.stream().filter((d) -> d.getEmp().getService().getId() == emp.getService().getId())
                .toList();
        demandes.stream().forEach((d) -> {
            res.add(new DemandeCongeDAO(d));
        });

        return res;
    }

    public List<DemandeConge> findAllDemandeUnderAuthUser() throws Exception {
        Employe emp = this.employeService.getAuthenticatedEmploye();
        List<DemandeConge> res = this.congeRepo.findAllDemandeCongeUnder(emp.getContrat().getCategorie().getValeur());
        res = res.stream().filter((d) -> d.getEmp().getService().getId() == emp.getService().getId()).toList();
        return res;
    }

    public void saveDemande(DemandeCongeDAO demandeCongeDAO) throws Exception {
        boolean canGo = checkDemandeConge(demandeCongeDAO);

        if (canGo) {
            DemandeConge demande = new DemandeConge();
            demande.setEmp(this.employeService.getAuthenticatedEmploye());
            demande.setMotif(demandeCongeDAO.getMotif());
            demande.setType(demandeCongeDAO.getType());
            demande.setStatus(0);
            demande.setDebut(demandeCongeDAO.getDebut());
            demande.setDebutDemiJournee(demandeCongeDAO.isDebutDemiJournee());
            demande.setFin(demandeCongeDAO.getFin());
            demande.setFinDemiJournee(demandeCongeDAO.isFinDemiJournee());
            this.congeRepo.save(demande);
        }
    }
}
