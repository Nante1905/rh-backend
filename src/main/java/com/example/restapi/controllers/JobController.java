package com.example.restapi.controllers;

import com.example.restapi.model.candidature.Candidature;
import com.example.restapi.model.candidature.CandidatureInfo;
import com.example.restapi.model.job.JobDetail;
import com.example.restapi.model.job.JobInfo;
import com.example.restapi.model.qcm.Question;
import com.example.restapi.model.qcm.Questionnaire;
import com.example.restapi.model.qcm.test.Test;
import com.example.restapi.repositories.qcm.TestRepository;
import com.example.restapi.services.CandidatureService;
import com.example.restapi.services.job.JobService;
import com.example.restapi.services.qcm.QuestionnaireService;
import com.example.restapi.services.qcm.TestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
@CrossOrigin("*")
public class JobController {
    @Autowired
    JobService jobService;
    @Autowired
    CandidatureService candidatureService;
    @Autowired
    QuestionnaireService questionnaireService;
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestService testService;

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("jobs", this.jobService.findAll());
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Optional<JobDetail> job = this.jobService.findById(id);
        if (job == null) {
            return ResponseEntity.status(404).body("Job doesn't exist");
        }
        return ResponseEntity.ok().body(job);
    }

    @GetMapping(path = "/{id}/candidatures")
    public ResponseEntity<List<CandidatureInfo>> findCandidatureOf(@PathVariable("id") int id) {
        System.out.println(" candidature of >>>> " + id);
        List<Candidature> list = this.candidatureService.findAllFor(id);
        List<CandidatureInfo> res = new ArrayList<CandidatureInfo>();

        list.stream().forEach((c) -> {
            res.add(new CandidatureInfo(c));
        });
        return ResponseEntity.ok().body(res);
    }

    @GetMapping(path = "/{id}/selections")
    public ResponseEntity<List<CandidatureInfo>> findSortedCandidatureOf(@PathVariable("id") int id) {
        System.out.println(" sélections >>>> " + id);
        List<Candidature> list = this.candidatureService.findAllSortByNoteFor(id);
        List<CandidatureInfo> res = new ArrayList<CandidatureInfo>();

        list.stream().forEach((c) -> {
            res.add(new CandidatureInfo(c));
        });
        return ResponseEntity.ok().body(res);
    }

    @GetMapping(path = "/annonce")
    public ResponseEntity<List<JobInfo>> findAnnonces() {
        return ResponseEntity.ok().body(this.jobService.findJobInfo());
    }

    @GetMapping(path = "/{id}/questionnaires")
    public ResponseEntity<Questionnaire> findQuestionnaire(@PathVariable("id") int idJob) {
        return ResponseEntity.ok().body(this.questionnaireService.findByIdJob(idJob));
    }

    @GetMapping(path = "/questionnaires")
    public ResponseEntity<List<Questionnaire>> findAllQuestionnaire() {
        return ResponseEntity.ok().body(this.questionnaireService.findAllQuestionnaire());
    }

    @GetMapping(path = "/questions/{id}")
    public ResponseEntity<List<Question>> findQuestion(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(this.questionnaireService.findQuestions(id));
    }

    @GetMapping(path = "/tests/{test}")
    public List<Test> findTest(@PathVariable("test") int idTest) {
        return testRepository.findById(idTest);
    }

    @PostMapping(path = "/tests")
    public ResponseEntity<Object> saveTest(@RequestBody Test test) {
        try {
            return ResponseEntity.ok().body(this.testService.save(test));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors de l'insertion test");
        }
    }
}