package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Ville;
import com.example.restapi.services.VilleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ville")
public class VilleControler {

    @Autowired
    private VilleService villeservice;

    @GetMapping
    public ResponseEntity<List<Ville>> findAllVille() {
        List<Ville> ville = villeservice.findAllVille();
        return ResponseEntity.ok().body(ville);
    }
}
