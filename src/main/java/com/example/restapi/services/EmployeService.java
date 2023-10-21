package com.example.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.employe.Employe;
import com.example.restapi.repositories.EmployeRepository;

@Service
public class EmployeService {

    @Autowired
    EmployeRepository empRepository;
    @Autowired
    private UtilisateurService utilisateurService;

    public List<Employe> findByMission(String mission) {
        return this.empRepository.findByContrat_JobMissionContainingIgnoreCase(mission);
    }

    public String generateMatricule() {
        long count = this.empRepository.count();
        return "E" + String.format("%04d", count + 1);
    }

    public Employe save(Employe e) {
        e.setMatricule(this.generateMatricule());
        return this.empRepository.save(e);
    }

    public List<Employe> findAll() {
        return this.empRepository.findAll();
    }

    public Optional<Employe> findById(int id) {
        return this.empRepository.findById(id);
    }

    public Employe getAuthenticatedEmploye() throws Exception {
        Utilisateur u = this.utilisateurService.getAuthenticatedUser()
                .orElseThrow(() -> new Exception("Not Connected"));
        Employe e = this.empRepository.findByUtilisateur(u);
        int idChef = this.empRepository.getIdChef(e.getService().getId());
        e.setChef(e.getId() == idChef);
        return e;
    }
}
