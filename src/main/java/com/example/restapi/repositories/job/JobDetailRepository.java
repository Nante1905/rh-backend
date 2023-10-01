package com.example.restapi.repositories.job;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.job.JobDetail;

public interface JobDetailRepository extends JpaRepository<JobDetail, Integer> {

}
