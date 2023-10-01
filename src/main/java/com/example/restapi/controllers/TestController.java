package com.example.restapi.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.job.JobDetail;
import com.example.restapi.repositories.job.JobDetailRepository;
import com.example.restapi.repositories.job.JobRepository;
import com.example.restapi.services.job.JobService;

import jakarta.persistence.EntityManager;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobService jobService;
    @Autowired
    private JobDetailRepository jobDetailRepository;

    @GetMapping("")
    public List<JobDetail> getEmployes() {
        return jobDetailRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> saveJob(@RequestBody JobDetail job) throws Exception {
        HashMap<String, Object> result = new HashMap<>();

        System.out.println(job.getService().getId());

        // try {
        result.put("OK", true);
        result.put("data", this.jobService.save(job));
        return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);
        // } catch (Exception e) {
        // result.put("OK", false);
        // result.put("data", e);
        // return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);
        // }
    }

}
