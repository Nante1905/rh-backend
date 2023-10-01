package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.job.Job;
import com.example.restapi.model.job.JobDetail;
import com.example.restapi.repositories.job.JobDetailRepository;
import com.example.restapi.repositories.job.JobRepository;
import com.example.restapi.services.job.JobService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobService jobService;
    @Autowired
    private JobDetailRepository jobDetailRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public List<JobDetail> getEmployes() {
        return jobDetailRepository.findAll();
    }

    @PostMapping("/save")
    public JobDetail saveJob(@RequestBody JobDetail job) throws Exception {
        return this.jobService.save(job).get();
    }
}
