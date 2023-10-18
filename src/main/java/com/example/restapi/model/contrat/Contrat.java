package com.example.restapi.model.contrat;

import java.time.LocalDate;
import java.util.List;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.job.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "id_job")
    Job job;
    @ManyToOne
    @JoinColumn(name = "id_type_contrat")
    TypeContrat type;
    double salaireBrut;
    @Column(name = "date_debut")
    LocalDate debut;

    @Column(name = "date_fin")
    LocalDate fin;

    @ManyToMany
    @JoinTable(name = "contrat_avantage", joinColumns = @JoinColumn(name = "id_contrat"), inverseJoinColumns = @JoinColumn(name = "id_avantage"))
    List<Avantage> avantages;

    @OneToOne
    @JoinColumn(name = "id_categorie")
    Categorie categorie;
}