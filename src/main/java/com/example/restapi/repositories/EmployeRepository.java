package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.employe.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
