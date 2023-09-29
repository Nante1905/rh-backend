package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
