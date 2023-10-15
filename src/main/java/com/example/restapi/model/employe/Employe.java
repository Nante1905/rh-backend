package com.example.restapi.model.employe;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restapi.model.candidature.Candidature;
import com.example.restapi.model.candidature.CandidatureInfo;
import com.example.restapi.repositories.EmployeRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_candidature")
    Candidature candidature;
    String matricule;
    @JsonProperty("info")
    CandidatureInfo candidatureInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public CandidatureInfo getCandidatureInfo() {
        return new CandidatureInfo(this.getCandidature());
    }

    public void setCandidatureInfo(CandidatureInfo candidatureInfo) {
        this.candidatureInfo = candidatureInfo;
    }

}
