package com.example.restapi.model.qcm.test;

import com.example.restapi.model.candidature.Candidature;
import com.example.restapi.model.candidature.CandidatureInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "v_test_note_job")
public class ResultatCandidat {
    @Id
    @Column(name = "id_test")
    int id;
    int note;
    int total;
    int idJob;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_candidat")
    Candidature candidature;
    @JsonProperty("candidature")
    @Transient
    CandidatureInfo candidatureInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public CandidatureInfo getCandidatureInfo() {
        return new CandidatureInfo(candidature);
    }

    public void setCandidatureInfo(CandidatureInfo candidatureInfo) {
        this.candidatureInfo = candidatureInfo;
    }
}
