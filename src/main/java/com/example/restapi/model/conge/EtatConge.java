package com.example.restapi.model.conge;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_etat_conge")
@Getter
@Setter
public class EtatConge {
    @Id
    int idEmploye;
    double cumul;
    double consomme;
    @Transient
    double reste;

    public double getReste() {
        return this.getCumul() - this.getConsomme();
    }
}
