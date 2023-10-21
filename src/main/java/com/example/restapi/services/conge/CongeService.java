package com.example.restapi.services.conge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.exceptions.CongeException;
import com.example.restapi.model.conge.CongeConsomme;
import com.example.restapi.model.conge.DemandeConge;
import com.example.restapi.model.conge.TypeConge;
import com.example.restapi.model.employe.Employe;
import com.example.restapi.repositories.EmployeRepository;
import com.example.restapi.repositories.conge.CongeConsommeRepository;
import com.example.restapi.repositories.conge.CongeRepository;
import com.example.restapi.repositories.conge.TypeCongeRepository;

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
    TypeCongeRepository typecongeRepo;

    public List<DemandeConge> findAll() {
        return this.congeRepo.findAll();
    }

    public List<TypeConge> findAllTypeConge() {
        return this.typecongeRepo.findAll();
    }

    @Transactional(rollbackOn = { Exception.class })
    public void acceptDemande(int id) throws Exception {
        DemandeConge demande = this.congeRepo.findById(id)
                .orElseThrow(() -> new Exception("Demande de congé introuvable"));
        this.congeRepo.updateStatus(id, 5);
        double duree = demande.getDuree();
        System.out.println("dureee " + duree + "=====================");
        CongeConsomme c = new CongeConsomme(demande.getEmp().getId(), duree);
        this.consommeRepo.save(c);
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
}
