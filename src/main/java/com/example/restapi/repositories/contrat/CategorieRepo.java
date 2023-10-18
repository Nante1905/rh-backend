package com.example.restapi.repositories.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.contrat.Categorie;

public interface CategorieRepo extends JpaRepository<Categorie, Integer> {

}
