package com.example.restapi.model.cv;

import java.time.LocalDate;

import com.example.restapi.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "cv")
public class DetailsCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate creation;
    String nom;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;
    @OneToOne
    @JoinColumn(name = "id")
    CvDiplome diplome;
    @OneToOne
    @JoinColumn(name = "id")
    CvDomaine domaine;
    @OneToOne
    @JoinColumn(name = "id")
    CvMatrimonial matrimonial;
    @OneToOne
    @JoinColumn(name = "id")
    CvExperience experience;
    @OneToOne
    @JoinColumn(name = "id")
    CvFichier fichier;

    public DetailsCv() {
    }

    @Override
    public String toString() {
        return this.getId() + " nom " + this.getNom() + " u: " + this.getUtilisateur() + " fichier: "
                + this.getFichier() + " dipl : "
                + this.getDiplome();
    }

    public CvFichier getFichier() {
        return fichier;
    }

    public void setFichier(CvFichier fichier) {
        this.fichier = fichier;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public CvExperience getExperience() {
        return experience;
    }

    public void setExperience(CvExperience experience) {
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CvDiplome getDiplome() {
        return diplome;
    }

    public void setDiplome(CvDiplome diplome) {
        this.diplome = diplome;
    }

    public CvDomaine getDomaine() {
        return domaine;
    }

    public void setDomaine(CvDomaine domaine) {
        this.domaine = domaine;
    }

    public CvMatrimonial getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(CvMatrimonial matrimonial) {
        this.matrimonial = matrimonial;
    }

}
