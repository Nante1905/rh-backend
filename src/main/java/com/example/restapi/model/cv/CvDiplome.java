package com.example.restapi.model.cv;

import com.example.restapi.model.Diplome;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CvDiplome {
    @Id
    int idCv;
    @ManyToOne
    @JoinColumn(name = "id_diplome")
    Diplome diplome;

    public CvDiplome() {
    }

    public String toString() {
        return this.idCv + " " + this.getDiplome().getId();
    }

    public int getIdCv() {
        return idCv;
    }

    public void setIdCv(int idCv) {
        this.idCv = idCv;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

}
