package com.example.restapi.model.job;

import com.example.restapi.model.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class JobDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int idJob;
    String title;
    double volume;
    int man_day;
    double sal_min;
    double sal_max;

    @ManyToOne
    @JoinColumn(name = "idservice")
    Service service;

    @OneToOne
    @JoinColumn(name = "id")
    JobDiplome jobDiplome;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id_job")
    JobExperience jobExperience;

    @OneToOne
    @JoinColumn(name = "id")
    JobMatrimoniale jobMatrimoniale;

    @OneToOne
    @JoinColumn(name = "id")
    JobNationalite jobNationalite;

    @OneToOne
    @JoinColumn(name = "id")
    JobSexe jobSexe;

    public JobSexe getJobSexe() {
        return jobSexe;
    }

    public void setJobSexe(JobSexe jobSexe) {
        this.jobSexe = jobSexe;
    }

    public JobNationalite getJobNationalite() {
        return jobNationalite;
    }

    public void setJobNationalite(JobNationalite jobNationalite) {
        this.jobNationalite = jobNationalite;
    }

    public JobMatrimoniale getJobMatrimoniale() {
        return jobMatrimoniale;
    }

    public void setJobMatrimoniale(JobMatrimoniale jobMatrimoniale) {
        this.jobMatrimoniale = jobMatrimoniale;
    }

    public JobExperience getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(JobExperience jobExperience) {
        this.jobExperience = jobExperience;
    }

    public JobDiplome getJobDiplome() {
        return jobDiplome;
    }

    public void setJobDiplome(JobDiplome jobDiplome) {
        this.jobDiplome = jobDiplome;
    }

    public JobDetail() {
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
