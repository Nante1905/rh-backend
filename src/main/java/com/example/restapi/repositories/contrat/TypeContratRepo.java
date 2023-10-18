package com.example.restapi.repositories.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.contrat.TypeContrat;

public interface TypeContratRepo extends JpaRepository<TypeContrat, Integer> {

}
