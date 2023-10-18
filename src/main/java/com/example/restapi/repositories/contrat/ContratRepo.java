package com.example.restapi.repositories.contrat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.contrat.Contrat;

public interface ContratRepo extends JpaRepository<Contrat, Integer> {
    @Query(value = "select * from contrat where id_utilisateur=?1", nativeQuery = true)
    public List<Contrat> findAllByIdUtilisateur(int id);

    @Query(value = "select * from contrat where id_utilisateur=?1 and status=?2", nativeQuery = true)
    public List<Contrat> findContratsByStatus(int id, int status);

    @Modifying
    @Query(value = "update contrat set status=?2 where id=?1", nativeQuery = true)
    public void updateStatus(int id, int status);
}
