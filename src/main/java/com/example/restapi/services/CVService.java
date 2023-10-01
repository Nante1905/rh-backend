package com.example.restapi.services;

import java.util.List;
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
    @Autowired
    FileService fileService;

    // @Transactional(rollbackOn = { Exception.class })
    // public void save(DetailsCv cv, MultipartFile cvFile, MultipartFile
    // certificat)
    // throws FileException, FileAlreadyExistsException {
    // Cv toInsert = new Cv(cv.getNom(), cv.getUtilisateur());
    // Cv inserted = this.cvRepository.save(toInsert);

    // String cvName =
    // inserted.getUtilisateur().generateFileName(cvFile.getOriginalFilename(),
    // "cv");
    // String certificatName =
    // inserted.getUtilisateur().generateFileName(certificat.getOriginalFilename(),
    // "certificat");
    // // cv_diplome
    // CvDiplome diplome = cv.getDiplome();
    // diplome.setIdCv(inserted.getId());
    // entityManager.persist(diplome);
    // // cv_domaine
    // CvDomaine domaine = cv.getDomaine();
    // domaine.setIdCv(inserted.getId());
    // entityManager.persist(domaine);
    // // cv_matrimonial
    // CvMatrimonial matrimonial = cv.getMatrimonial();
    // matrimonial.setIdCv(inserted.getId());
    // entityManager.persist(matrimonial);
    // // cv_experience
    // CvExperience experience = cv.getExperience();
    // experience.setIdCv(inserted.getId());
    // entityManager.persist(experience);

    // // cv_file
    // CvFichier fichier = new CvFichier(cvName, certificatName);
    // entityManager.persist(fichier);
    // fileService.save(cvFile, cvName);
    // fileService.save(certificat, certificatName);
    // }

    @Transactional(rollbackOn = { Exception.class })
    public void save(DetailsCv cv)
            throws Exception {
        Cv toInsert = new Cv(cv.getNom(), cv.getUtilisateur());
        Cv inserted = this.cvRepository.save(toInsert);

        // String cvName =
        // inserted.getUtilisateur().generateFileName(cvFile.getOriginalFilename(),
        // "cv");
        // String certificatName =
        // inserted.getUtilisateur().generateFileName(certificat.getOriginalFilename(),
        // "certificat");
        // cv_diplome
        CvDiplome diplome = cv.getDiplome();
        diplome.setIdCv(inserted.getId());
        entityManager.persist(diplome);
        // cv_domaine
        CvDomaine domaine = cv.getDomaine();
        domaine.setIdCv(inserted.getId());
        entityManager.persist(domaine);
        // cv_matrimonial
        CvMatrimonial matrimonial = cv.getMatrimonial();
        matrimonial.setIdCv(inserted.getId());
        entityManager.persist(matrimonial);
        // cv_experience
        CvExperience experience = cv.getExperience();
        experience.setIdCv(inserted.getId());
        entityManager.persist(experience);

        // cv_file
        // CvFichier fichier = new CvFichier(cvName, certificatName);
        // entityManager.persist(fichier);
        // fileService.save(cvFile, cvName);
        // fileService.save(certificat, certificatName);
    }

    public Optional<DetailsCv> findById(int id) {
        return this.detailsRepository.findById(id);
    }

    public List<DetailsCv> findAll() {
        return this.detailsRepository.findAll();
    }
}
