package com.example.restapi.model.qcm.test;

import java.util.List;

import com.example.restapi.model.qcm.Reponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "question")
public class QuestionCandidat {
    @Id
    int id;
    String contenu;
    int coeff;
    // @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch =
    // FetchType.LAZY)
    @Transient
    List<ReponseCandidat> reponses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

}
