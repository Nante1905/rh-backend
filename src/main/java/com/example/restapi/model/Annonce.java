package com.example.restapi.model;

public class Annonce {
    int id;
    int idJob;
    Job job;
    
    public Annonce(int id, int idJob, Job job) {
        this.id = id;
        this.idJob = idJob;
        this.job = job;
    }

    public Annonce() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}