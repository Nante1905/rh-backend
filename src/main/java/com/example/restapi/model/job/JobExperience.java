package com.example.restapi.model.job;

import com.example.restapi.model.Experience;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class JobExperience {
    @Id
    @Column(name = "id_job")
    int idJob;

    @OneToOne
    @JoinColumn(name = "id_experience")
    Experience experience;

    int coeff;

    public JobExperience() {
    }

    public JobExperience(int idJob, Experience experience, int coeff) {
        this.setIdJob(idJob);
        this.setExperience(experience);
        this.setCoeff(coeff);
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

}
