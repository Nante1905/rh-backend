package com.example.restapi.services;

import org.springframework.stereotype.Service;

import com.example.restapi.model.Job;
import com.example.restapi.repositories.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public Job save(Job job) {
        return this.jobRepository.save(job);
    }
}