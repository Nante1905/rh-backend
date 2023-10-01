package com.example.restapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.cv.Cv;
import com.example.restapi.model.cv.CvDiplome;
import com.example.restapi.model.cv.CvDomaine;
import com.example.restapi.model.cv.CvExperience;
import com.example.restapi.model.cv.CvMatrimonial;
import com.example.restapi.model.cv.DetailsCv;
import com.example.restapi.repositories.CVRepository;
import com.example.restapi.repositories.DetailsCVRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CVService {
    @Autowired
    CVRepository cvRepository;
    @Autowired
    EntityManager entityManager;
    @Autowired
    DetailsCVRepository detailsRepository;

    @Transactional(rollbackOn = { Exception.class })
    public void save(DetailsCv cv) {
        Cv toInsert = new Cv(cv.getNom(), cv.getUtilisateur());
        Cv inserted = this.cvRepository.save(toInsert);
        System.out.println(">>> " + inserted.toString());
        CvDiplome diplome = cv.getDiplome();
        diplome.setIdCv(inserted.getId());
        entityManager.persist(diplome);
        CvDomaine domaine = cv.getDomaine();
        domaine.setIdCv(inserted.getId());
        entityManager.persist(domaine);
        CvMatrimonial matrimonial = cv.getMatrimonial();
        matrimonial.setIdCv(inserted.getId());
        entityManager.persist(matrimonial);
        CvExperience experience = cv.getExperience();
        experience.setIdCv(inserted.getId());
        entityManager.persist(experience);
    }

    public Optional<DetailsCv> findById(int id) {
        return this.detailsRepository.findById(id);
    }
}
