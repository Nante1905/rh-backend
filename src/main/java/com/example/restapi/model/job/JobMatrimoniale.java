package com.example.restapi.model.job;

import com.example.restapi.model.Matrimonial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class JobMatrimoniale {
    @Id
    @Column(name = "id_job")
    int idJob;

    @OneToOne
    @JoinColumn(name = "idmatrimoniale")
    Matrimonial matrimonial;

    int coeff;

    public JobMatrimoniale() {
    }

    public JobMatrimoniale(int idJob, Matrimonial matrimonial, int coeff) {
        this.setIdJob(idJob);
        this.setMatrimonial(matrimonial);
        this.setCoeff(coeff);
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public Matrimonial getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(Matrimonial matrimonial) {
        this.matrimonial = matrimonial;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

}
