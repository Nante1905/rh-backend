package com.example.restapi.repositories.conge;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.conge.CongeConsomme;

public interface CongeConsommeRepository extends JpaRepository<CongeConsomme, Integer> {
    public Optional<CongeConsomme> findByIdEmploye(int id);
}
