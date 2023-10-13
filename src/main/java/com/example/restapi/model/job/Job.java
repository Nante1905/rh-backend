package com.example.restapi.model.job;

import java.time.LocalDate;

import com.example.restapi.model.Service;
import com.example.restapi.model.TypeContrat;
import com.example.restapi.model.Ville;

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
    int nbr_personne;
    int min_age;
    int max_age;
    double sal_min;
    double sal_max;
    @Column(insertable = false)
    LocalDate jour;

    @OneToOne
    @JoinColumn(name = "id_service")
    Service service;

    @OneToOne
    @JoinColumn(name = "id_type_contrat")
    TypeContrat typecontrat;

    @OneToOne
    @JoinColumn(name = "id_ville")
    Ville ville;

    public Job(int idJob, String title, double volume, int man_day, double sal_min, double sal_max, Service service,
            LocalDate jour,
            TypeContrat typecontrat, int nbr_personne, int min_age, int max_age, Ville ville) {
        this.idJob = idJob;
        this.title = title;
        this.volume = volume;
        this.man_day = man_day;
        this.sal_min = sal_min;
        this.sal_max = sal_max;
        this.service = service;
        this.jour = jour;
        this.typecontrat = typecontrat;
        this.nbr_personne = nbr_personne;
        this.min_age = min_age;
        this.max_age = max_age;
        this.ville = ville;
    }

    public Job() {
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

    public TypeContrat getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(TypeContrat typecontrat) {
        this.typecontrat = typecontrat;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
