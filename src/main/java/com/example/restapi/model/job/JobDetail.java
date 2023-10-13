package com.example.restapi.model.job;

import java.time.LocalDate;

import com.example.restapi.model.Service;
import com.example.restapi.model.TypeContrat;
import com.example.restapi.model.Ville;
import com.example.restapi.model.qcm.Questionnaire;

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
    int nbr_personne;
    int min_age;
    int max_age;
    double sal_min;
    double sal_max;
    @Column(insertable = false)
    LocalDate jour;

    @ManyToOne
    @JoinColumn(name = "id_service")
    Service service;

    @ManyToOne
    @JoinColumn(name = "id_ville")
    Ville ville;

    @ManyToOne
    @JoinColumn(name = "id_type_contrat")
    TypeContrat typeContrat;

    @OneToOne
    @JoinColumn(name = "id")
    JobDiplome jobDiplome;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id_job")
    JobExperience jobExperience;

    @OneToOne
    @JoinColumn(name = "id")
    JobMatrimonial jobMatrimoniale;

    @OneToOne
    @JoinColumn(name = "id")
    JobNationalite jobNationalite;

    @OneToOne
    @JoinColumn(name = "id")
    JobSexe jobSexe;

    @OneToOne
    @JoinColumn(name = "id")
    Questionnaire questionnaire;

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

    public int getNbr_personne() {
        return nbr_personne;
    }

    public void setNbr_personne(int nbr_personne) {
        this.nbr_personne = nbr_personne;
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    public void setMax_age(int max_age) {
        this.max_age = max_age;
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

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public JobDiplome getJobDiplome() {
        return jobDiplome;
    }

    public void setJobDiplome(JobDiplome jobDiplome) {
        this.jobDiplome = jobDiplome;
    }

    public JobExperience getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(JobExperience jobExperience) {
        this.jobExperience = jobExperience;
    }

    public JobMatrimonial getJobMatrimoniale() {
        return jobMatrimoniale;
    }

    public void setJobMatrimoniale(JobMatrimonial jobMatrimoniale) {
        this.jobMatrimoniale = jobMatrimoniale;
    }

    public JobNationalite getJobNationalite() {
        return jobNationalite;
    }

    public void setJobNationalite(JobNationalite jobNationalite) {
        this.jobNationalite = jobNationalite;
    }

    public JobSexe getJobSexe() {
        return jobSexe;
    }

    public void setJobSexe(JobSexe jobSexe) {
        this.jobSexe = jobSexe;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public int getMan_day() {
        return man_day;
    }

    public void setMan_day(int man_day) {
        this.man_day = man_day;
    }
}