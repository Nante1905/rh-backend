package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    // public Utilisateur save(Utilisateur u);
}
