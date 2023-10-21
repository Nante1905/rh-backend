package com.example.restapi.repositories.conge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.conge.DemandeConge;
import java.util.List;
import com.example.restapi.model.employe.Employe;

public interface CongeRepository extends JpaRepository<DemandeConge, Integer> {

    @Modifying
    @Query(value = "update demande_conge set status = ?2 where id = ?1 ", nativeQuery = true)
    public void updateStatus(int id, int status);

    public List<DemandeConge> findByEmp(Employe emp);
}
