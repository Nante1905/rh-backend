package com.example.restapi.controllers;

import com.example.restapi.model.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;


    public Job insert(@RequestBody Job job) {
        return this.jobService.save(job);
    }
    
}