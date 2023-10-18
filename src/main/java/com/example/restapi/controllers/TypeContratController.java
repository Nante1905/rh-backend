package com.example.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.TypeContrat;
import com.example.restapi.services.TypeContratService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contrats")
public class TypeContratController {

    @Autowired
    private TypeContratService typeContratService;

    @GetMapping
    public ResponseEntity<List<TypeContrat>> findAllTypeContrat() {
        List<TypeContrat> typesContrat = typeContratService.findAllTypeContrat();
        return ResponseEntity.ok().body(typesContrat);
    }

}
