package com.example.restapi.repositories.conge;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.conge.EtatConge;

public interface EtatCongeRepository extends JpaRepository<EtatConge, Integer> {

}
