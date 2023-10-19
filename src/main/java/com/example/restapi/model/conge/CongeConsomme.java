package com.example.restapi.model.conge;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conge_consomme")
@Getter
@Setter
@NoArgsConstructor
public class CongeConsomme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int idEmploye;
    double jour;

    public CongeConsomme(int idEmploye, double jour) {
        setIdEmploye(idEmploye);
        setJour(jour);
    }
}
