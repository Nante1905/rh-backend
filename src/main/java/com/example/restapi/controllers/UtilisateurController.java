package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.services.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    UtilisateurService uService;

    @GetMapping()
    public List<Utilisateur> findAll() {
        return this.uService.findAll();
    }

    @PostMapping(value = "sign")
    public Utilisateur signIn(@RequestBody Utilisateur u) {
        return this.uService.save(u);
    }

}
