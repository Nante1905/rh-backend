package com.example.restapi.model.job;

import com.example.restapi.model.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int idJob;
    String title;
    double volume;
    int man_day;
    double sal_min;
    double sal_max;

    @OneToOne
    @JoinColumn(name = "idservice")
    Service service;

    public Job() {
    }

    public Job(String title, double volume, int man_day, double sal_min, double sal_max, Service service) {
        this.title = title;
        this.volume = volume;
        this.man_day = man_day;
        this.sal_min = sal_min;
        this.sal_max = sal_max;
        this.service = service;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getMan_day() {
        return man_day;
    }

    public void setMan_day(int man_day) {
        this.man_day = man_day;
    }

    public double getSal_min() {
        return sal_min;
    }

    public void setSal_min(double sal_min) {
        this.sal_min = sal_min;
    }

    public double getSal_max() {
        return sal_max;
    }

    public void setSal_max(double sal_max) {
        this.sal_max = sal_max;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}