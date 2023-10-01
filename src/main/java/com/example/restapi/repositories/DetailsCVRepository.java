package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.cv.DetailsCv;

public interface DetailsCVRepository extends JpaRepository<DetailsCv, Integer> {

}
