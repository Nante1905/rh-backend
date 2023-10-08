package com.example.restapi.repositories.job;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.job.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
