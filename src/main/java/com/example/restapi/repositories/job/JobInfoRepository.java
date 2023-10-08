package com.example.restapi.repositories.job;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.job.JobInfo;

public interface JobInfoRepository extends JpaRepository<JobInfo, Integer> {

}
