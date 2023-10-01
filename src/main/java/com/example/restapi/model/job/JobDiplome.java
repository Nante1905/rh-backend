package com.example.restapi.model.job;

import com.example.restapi.model.Diplome;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_diplome")
public class JobDiplome {
    @Id
    @Column(name = "id_job")
    int idJob;

    @OneToOne
    @JoinColumn(name = "iddiplome")
    Diplome diplome;

    int coeff;

    // int idDiplome;

    // public JobDiplome(Diplome diplome, int coeff) {
    // this.diplome = diplome;
    // this.coeff = coeff;
    // }

    public JobDiplome(int idJob, Diplome diplome, int coeff) {
        this.setIdJob(idJob);
        this.setDiplome(diplome);
        this.setCoeff(coeff);
    }

    public JobDiplome() {
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

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }
}