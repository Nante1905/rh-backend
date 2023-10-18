package com.example.restapi.repositories.contrat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.contrat.Contrat;

public interface ContratRepo extends JpaRepository<Contrat, Integer> {
    @Query(value = "select * from contrat where id_utilisateur=?1", nativeQuery = true)
    public List<Contrat> findAllByIdUtilisateur(int id);
}
