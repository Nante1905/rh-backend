package com.example.restapi.model.cv;

import com.example.restapi.model.Experience;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CvExperience {
    @Id
    int idCv;
    @ManyToOne
    @JoinColumn(name = "id_experience")
    Experience experience;

    public CvExperience() {
    }

    public int getIdCv() {
        return idCv;
    }

    public void setIdCv(int idCv) {
        this.idCv = idCv;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

}
