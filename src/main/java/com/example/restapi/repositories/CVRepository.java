package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.cv.Cv;

public interface CVRepository extends JpaRepository<Cv, Integer> {

}
