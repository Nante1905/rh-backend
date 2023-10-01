package com.example.restapi.model.cv;

import com.example.restapi.model.Matrimonial;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CvMatrimonial {
    @Id
    int idCv;
    @ManyToOne
    @JoinColumn(name = "id_matrimonial")
    Matrimonial matrimonial;

    public CvMatrimonial() {
    }

    public int getIdCv() {
        return idCv;
    }

    public void setIdCv(int idCv) {
        this.idCv = idCv;
    }

    public Matrimonial getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(Matrimonial matrimonial) {
        this.matrimonial = matrimonial;
    }

}
