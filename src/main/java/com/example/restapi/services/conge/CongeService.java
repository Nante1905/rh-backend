package com.example.restapi.services.conge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import com.example.restapi.exceptions.CongeException;
import com.example.restapi.model.conge.CongeConsomme;
import com.example.restapi.model.conge.DemandeConge;
import com.example.restapi.model.conge.DemandeCongeDAO;
import com.example.restapi.model.conge.EtatConge;
import com.example.restapi.model.employe.Employe;
import com.example.restapi.repositories.EmployeRepository;
import com.example.restapi.repositories.conge.CongeConsommeRepository;
import com.example.restapi.repositories.conge.CongeRepository;
import com.example.restapi.repositories.conge.EtatCongeRepository;
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
    EtatCongeRepository etatCongeRepo;

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

    public HashMap<String, Object> findConge() throws Exception {
        HashMap<String, Object> res = new HashMap<String, Object>();
        List<DemandeCongeDAO> demandes = new ArrayList<DemandeCongeDAO>();
        this.findByAuthenticatedEmp().stream().forEach((d) -> {
            demandes.add(new DemandeCongeDAO(d));
        });
        // soloina an'ilay get Authenticated employe an'i Nante
        Employe e = new Employe(1);
        EtatConge etat = findEtatConge(e.getId());
        res.put("etat", etat);
        res.put("conge", demandes);
        return res;
    }

    public EtatConge findEtatConge(int idEmp) throws Exception {
        return this.etatCongeRepo.findById(idEmp).orElseThrow(() -> new Exception("Etat de congé introuvable"));
    }

    public List<DemandeConge> findByAuthenticatedEmp() {
        // Ovaina an'ilay get AuthenticatedEmp any am Nante
        Employe emp = new Employe(1);
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
                CongeConsomme c = new CongeConsomme(demande.getEmp().getId(), duree);
                this.consommeRepo.save(c);
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

    public boolean checkDemandeConge(int id) throws Exception {
        // Alaina aloha ilay DemandeConge
        // Alaina ny emp an'ilay DemandeConge, ovaina getter an'i Employe zany ito
        // if(DemandeConge.TypeConge.deductible == false) => return true else
        Employe emp = new Employe(1);
        // Demandeconge.fin-DemandeConge.debut
        int nbr = 2;
        int rest = this.getResteConge(emp.getId());
        // si demandeconget.type.genre ne contains pas demandeConge.emp.genre.id =>
        // throw Exception
        if (rest < nbr) {
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

    public List<DemandeConge> findAllDemandeUnderAuthUser() throws Exception {
        Employe emp = this.employeService.getAuthenticatedEmploye();
        return this.congeRepo.findAllDemandeCongeUnder(emp.getContrat().getCategorie().getValeur());
    }
}
