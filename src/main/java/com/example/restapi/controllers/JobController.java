package com.example.restapi.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.services.job.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin("*")
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("jobs", this.jobService.findAll());
        return ResponseEntity.ok().body(result);
    }
}