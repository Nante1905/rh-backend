package com.example.restapi.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.job.JobDetail;
import com.example.restapi.model.job.JobDiplome;
import com.example.restapi.repositories.job.JobDetailRepository;
import com.example.restapi.services.UtilisateurService;
import com.example.restapi.services.authentication.JWTManager;
import com.example.restapi.services.job.JobService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private JobService jobService;
    @Autowired
    private JobDetailRepository jobDetailRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JWTManager jwt;

    @GetMapping("")
    public Optional<Utilisateur> test() throws Exception {
        return utilisateurService
                .findUtilisateurByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/role")
    @Secured("ADMIN")
    public Collection<? extends GrantedAuthority> testRole() throws Exception {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
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

    @PostMapping("/test")
    @Transactional
    public void save(@RequestBody JobDiplome diplome) {
        entityManager.persist(diplome);
    }

}
