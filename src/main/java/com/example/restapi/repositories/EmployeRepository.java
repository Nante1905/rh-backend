package com.example.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.employe.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    public List<Employe> findByContrat_JobMissionContainingIgnoreCase(String mission);

    @Query(value = "select cumul-consomme as reste from v_etat_conge where id_employe = ?1 ", nativeQuery = true)
    public int getRestConge(int id);
}
