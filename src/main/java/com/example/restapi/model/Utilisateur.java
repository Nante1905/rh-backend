package com.example.restapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.restapi.customException.FileException;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Utilisateur
 */
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String prenom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate naissance;
    String email;
    String telephone;
    String mdp;
    @ManyToOne
    @JoinColumn(name = "id_ville")
    Ville ville;
    @ManyToOne
    @JoinColumn(name = "id_nationalite")
    Nationalite nationalite;
    @ManyToOne
    @JoinColumn(name = "id_sexe")
    Genre genre;

    public Utilisateur() {
    }

    // type: CV, certificat?
    public String generateFileName(String originalName, String type) throws FileException {
        String[] wordsInName = originalName.split("\\.");
        if (wordsInName.length == 0) {
            throw new FileException("Type de fichier méconnaissable");
        }
        String extension = wordsInName[wordsInName.length - 1];
        if (extension.compareTo("pdf") != 0) {
            throw new FileException(originalName + " doit être un pdf");
        }
        return this.getNom() + "_" + type + "_" + LocalDateTime.now().toString() + "." + extension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
