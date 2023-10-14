package com.example.restapi.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.candidature.Candidature;
import com.example.restapi.model.candidature.CandidatureInfo;
import com.example.restapi.model.candidature.dto.CandidatureDto;
import com.example.restapi.repositories.candidature.CandidatureDtoRepository;
import com.example.restapi.repositories.candidature.CandidatureRepository;

@Service
public class CandidatureService {
    @Autowired
    CandidatureRepository cRepository;

    @Autowired
    CandidatureDtoRepository candidatureDtoRepository;

    @Autowired
    UtilisateurService utilisateurService;

    public List<CandidatureInfo> findEntretienFor(int idJob) {
        List<Candidature> candidatures = this.cRepository.findByStatus(idJob, 2);
        List<CandidatureInfo> res = new ArrayList<CandidatureInfo>();
        for (Candidature c : candidatures) {
            res.add(new CandidatureInfo(c));
        }
        return res;
    }

    public List<Candidature> findAllFor(int idJob) {
        List<Candidature> candidatures = this.cRepository.findByIdJob(idJob);
        return candidatures;
    }

    public List<Candidature> findAllSortByNoteFor(int idJob) {
        List<Candidature> candidatures = this.cRepository.findByIdJob(idJob);
        candidatures.forEach(c -> {
            c.processNote();
        });
        candidatures.sort(Comparator.comparing(Candidature::getNote, Comparator.reverseOrder()));
        return candidatures;
    }

    public void save(CandidatureDto candidature) throws Exception {
        try {
            this.candidatureDtoRepository.save(candidature);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateCandidatureStatus(int idCandidature, int newStatus) throws Exception {
        this.candidatureDtoRepository.updateCandidatureStatus(idCandidature, newStatus);
    }

    public List<Candidature> findByIdUser(int idUser) throws Exception {
        return cRepository.findByIdUtilisateur(idUser);
    }

    public List<Candidature> findForCurrentUser() throws Exception {
        Utilisateur u = this.utilisateurService.getAuthenticatedUser().get();
        // System.out.println(u.getId() + " ===========================");
        return cRepository.findByIdUtilisateur(u.getId());
    }
}
