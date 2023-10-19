package com.example.restapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("{id}")
    public ResponseEntity<?> findAll(@PathVariable("id") int id) {
        Optional<Employe> emp = this.empService.findById(id);
        if(emp.isPresent()) {
            return ResponseEntity.ok().body(emp.get());
        }
        return ResponseEntity.status(404).body("Not found");
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employe employe) {
        this.empService.save(employe);
        HashMap<String, Boolean> res = new HashMap<String, Boolean>();
        res.put("success", true);
        return ResponseEntity.ok().body(res);
    }
}
