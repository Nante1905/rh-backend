package com.example.restapi.model.conge;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.example.restapi.model.contrat.TypeContrat;
import com.example.restapi.model.employe.Employe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "demande_conge")
@Getter
@Setter
public class DemandeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    Employe emp;
    String motif;
    @ManyToOne
    @JoinColumn(name = "id_type")
    TypeConge type;
    int status;
    LocalDate debut;
    boolean debutDemiJournee;
    LocalDate fin;
    boolean finDemiJournee;

    public double getDuree() {
        double days = ((double) ChronoUnit.DAYS.between(this.getDebut(), this.getFin()));
        if (isDebutDemiJournee()) {
            System.out.println(days + "analana demi journée debut ");
            days -= 0.5;
        }
        if (isFinDemiJournee()) {
            System.out.println(days + " ampiana demi journée fin");
            days -= 0.5;
        }
        return days;
    }

    public LocalDate getFin() {
        Double jour = this.getType().getJour();
        if (jour == null || this.getType().isDeductible()) {
            return fin;
        }

        return this.getDebut().plusDays(jour.longValue());
    }

}
