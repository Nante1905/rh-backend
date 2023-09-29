package com.example.restapi.model;

public class Service {
    int idSevice;
    String nom_service;

    public Service(int idSevice, String nom_service) {
        this.idSevice = idSevice;
        this.nom_service = nom_service;
    }

    public Service() {
    }

    public int getIdSevice() {
        return idSevice;
    }

    public void setIdSevice(int idSevice) {
        this.idSevice = idSevice;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }
}