package com.example.restapi.model.qcm.test;

import java.util.List;

import com.example.restapi.model.qcm.Reponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

// @Entity
public class ReponseCandidat {
    boolean valeurCandidat;

    public boolean isValeurCandidat() {
        return valeurCandidat;
    }

    public void setValeurCandidat(boolean valeurCandidat) {
        this.valeurCandidat = valeurCandidat;
    }

}
