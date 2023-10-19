package com.example.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.employe.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    public List<Employe> findByContrat_JobMissionContainingIgnoreCase(String mission);
}
