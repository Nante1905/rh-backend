package com.example.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservice")
    int id;
    String nom_service;

    public Service(int idSevice, String nom_service) {
        this.id = idSevice;
        this.nom_service = nom_service;
    }

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int idService) {
        this.id = idService;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }
}