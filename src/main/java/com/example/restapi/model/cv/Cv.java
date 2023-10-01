package com.example.restapi.model.cv;

import java.time.LocalDate;

import com.example.restapi.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(insertable = false)
    LocalDate creation;
    String nom;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;

    public Cv() {
    }

    public Cv(String nom, Utilisateur u) {
        setNom(nom);
        setUtilisateur(u);
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getNom() + " " + this.getUtilisateur().getId();
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // public Utilisateur getUtilisateur() {
    // return utilisateur;
    // }

    // public void setUtilisateur(Utilisateur utilisateur) {
    // this.utilisateur = utilisateur;
    // }

    // public CvDiplome getDiplome() {
    // return diplome;
    // }

    // public void setDiplome(CvDiplome diplome) {
    // this.diplome = diplome;
    // }

}
