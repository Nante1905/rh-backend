package com.example.restapi.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String texte;

    int coeff;

    int id_questionnaire;

    @OneToMany(mappedBy = "question")
    Set<Reponse> reponses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return texte;
    }

    public void setText(String text) {
        this.texte = text;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    // public Set<Reponse> getReponses() {
    // return reponses;
    // }

    // public void setReponses(Set<Reponse> reponses) {
    // this.reponses = reponses;
    // }

    public int getId_questionnaire() {
        return id_questionnaire;
    }

    public void setId_questionnaire(int id_questionnaire) {
        this.id_questionnaire = id_questionnaire;
    }

}
