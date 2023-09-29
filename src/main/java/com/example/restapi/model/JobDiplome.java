package com.example.restapi.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class JobDiplome {
    int idJob;
    @ManyToOne
    @JoinColum(name = "idDiplome")
    Diplome diplome;
    int coeff;

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