package com.example.restapi.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_diplome")
public class JobDiplome {
    @Id
    @GenericGenerator(name = "receiverGen", strategy = "foreign", parameters = {
            @Parameter(name = "property", value = "jobDiplome") })
    @GeneratedValue(generator = "receiverGen")
    @Column(name = "idjobfk")
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