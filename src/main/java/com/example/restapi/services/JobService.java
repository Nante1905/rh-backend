package com.example.restapi.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public Job save(Job job) {
        return this.jobRepository.save(job);
    }
}