package com.example.restapi.model;

import jakarta.persistence.Column;
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
@Table(name = "job_diplome")
public class JobDiplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idJob;
    @OneToOne
    @JoinColumn(name = "idDiplome")
    @Transient
    Diplome diplome;
    int coeff;
    // int idDiplome;

    public JobDiplome(int idJob, Diplome diplome, int coeff) {
        this.idJob = idJob;
        this.diplome = diplome;
        this.coeff = coeff;
    }

    public JobDiplome() {
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
}