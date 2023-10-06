package com.example.restapi.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Candidature;
import com.example.restapi.repositories.candidature.CandidatureRepository;

@Service
public class CandidatureService {
    @Autowired
    CandidatureRepository cRepository;

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
}
