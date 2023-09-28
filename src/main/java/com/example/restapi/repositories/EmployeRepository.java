package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.Employe;

import jakarta.transaction.Transactional;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update employe set nom= ?1 where id=?2", nativeQuery = true)
    void setName(String name, int id);
}
