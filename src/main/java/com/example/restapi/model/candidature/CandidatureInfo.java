package com.example.restapi.model.candidature;

import java.time.LocalDate;

import com.example.restapi.model.Domaine;
import com.example.restapi.model.Matrimonial;
import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.cv.CvDiplome;
import com.example.restapi.model.cv.CvExperience;
import com.example.restapi.model.cv.CvFichier;

public class CandidatureInfo {
    int id;
    LocalDate depot;
    Utilisateur utilisateur;
    CvDiplome diplome;
    Domaine domaine;
    Matrimonial matrimonial;
    CvExperience experience;
    CvFichier fichier;
    double note;
    int status;

    public CandidatureInfo(Candidature model) {
        // CandidatureInfo c = new CandidatureInfo();
        this.setId(model.getId());
        this.setUtilisateur(model.getCv().getUtilisateur());
        this.setDepot(model.getDepot());
        this.setDiplome(model.getCv().getDiplome());
        this.setDomaine(model.getCv().getDomaine().getDomaine());
        this.setMatrimonial(model.getCv().getMatrimonial().getMatrimonial());
        this.setExperience(model.getCv().getExperience());
        this.setFichier(model.getCv().getFichier());
        this.setNote(model.getNote());
        this.setStatus(model.getStatus());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDepot() {
        return depot;
    }

    public void setDepot(LocalDate dept) {
        this.depot = dept;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Matrimonial getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(Matrimonial matrimonial) {
        this.matrimonial = matrimonial;
    }

    public CvExperience getExperience() {
        return experience;
    }

    public void setExperience(CvExperience experience) {
        this.experience = experience;
    }

    public CvFichier getFichier() {
        return fichier;
    }

    public void setFichier(CvFichier fichier) {
        this.fichier = fichier;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setDiplome(CvDiplome diplome) {
        this.diplome = diplome;
    }

    public CvDiplome getDiplome() {
        return diplome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
