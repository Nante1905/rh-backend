package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.cv.DetailsCv;
import com.example.restapi.services.CVService;
import com.example.restapi.services.UtilisateurService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    UtilisateurService uService;
    @Autowired
    CVService cvService;

    @GetMapping()
    public List<Utilisateur> findAll() {
        return this.uService.findAll();
    }

    @PostMapping(value = "sign")
    public Utilisateur signIn(@RequestBody Utilisateur u) {
        return this.uService.save(u);
    }

    @PostMapping(value = "cv/create")
    public void createCV(@RequestBody DetailsCv cv) {
        this.cvService.save(cv);
    }

}
