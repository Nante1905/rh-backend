package com.example.restapi.model;

public class Diplome {
    int idDiplome;
    String nom;
    int valeur;

    public Diplome() {
    }
    public Diplome(int idDiplome, String nom, int valeur) {
        this.idDiplome = idDiplome;
        this.nom = nom;
        this.valeur = valeur;
    }
    public int getIdDiplome() {
        return idDiplome;
    }
    public void setIdDiplome(int idDiplome) {
        this.idDiplome = idDiplome;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}