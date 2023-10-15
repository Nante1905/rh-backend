package com.example.restapi.controllers;

import java.util.HashMap;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.employe.Employe;
import com.example.restapi.services.EmployeService;

@RestController
@RequestMapping(path = "/employes")
public class EmployeController {

    @Autowired
    EmployeService empService;

    @GetMapping
    public ResponseEntity<List<Employe>> findAll() {
        return ResponseEntity.ok().body(this.empService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employe employe) {
        this.empService.save(employe);
        HashMap<String, Boolean> res = new HashMap<String, Boolean>();
        res.put("success", true);
        return ResponseEntity.ok().body(res);
    }
}
