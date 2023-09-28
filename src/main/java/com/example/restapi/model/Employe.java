package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Employe {
    @Id
    int id;
    String nom;

    @ManyToOne
    @JoinColumn(name = "direction")
    Direction direction;

    @Transient
    int age;

    public Employe(int id, String nom, Direction direction, int age) {
        this.id = id;
        this.nom = nom;
        this.direction = direction;
        this.age = age;
    }

    public Employe() {

    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
