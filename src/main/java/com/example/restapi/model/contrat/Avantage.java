package com.example.restapi.model.contrat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Avantage {
    @Id
    int id;
    String nom;
}
