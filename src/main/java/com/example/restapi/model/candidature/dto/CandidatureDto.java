package com.example.restapi.model.candidature.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidature")
public class CandidatureDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(insertable = false)
    LocalDate depot;
    int id_cv;
    int id_job;
    int status = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cv() {
        return id_cv;
    }

    public void setId_cv(int id_cv) {
        this.id_cv = id_cv;
    }

    public int getId_job() {
        return id_job;
    }

    public void setId_job(int id_job) {
        this.id_job = id_job;
    }

    public LocalDate getDepot() {
        return depot;
    }

    public void setDepot(LocalDate depot) {
        this.depot = depot;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
