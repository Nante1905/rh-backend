package com.example.restapi.model.cv;

import com.example.restapi.model.Domaine;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class CvDomaine {
    @Id
    int idCv;
    @ManyToOne
    @JoinColumn(name = "id_domaine")
    Domaine domaine;

    public CvDomaine() {
    }

    public int getIdCv() {
        return idCv;
    }

    public void setIdCv(int idCv) {
        this.idCv = idCv;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

}
