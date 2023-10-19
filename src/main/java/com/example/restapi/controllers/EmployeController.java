package com.example.restapi.controllers;

import java.util.ArrayList;
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
import com.example.restapi.model.employe.EmployeDTO;
import com.example.restapi.services.EmployeService;

@RestController
@RequestMapping(path = "/employes")
public class EmployeController {

    @Autowired
    EmployeService empService;

    // @GetMapping("/conges/{id}")
    // public ResponseEntity<Integer> findResteConge(@PathVariable("id") int id) {
    // return ResponseEntity.ok().body(this.empService.getResteConge(id));
    // }

    @GetMapping
    public ResponseEntity<List<EmployeDTO>> findAll() {
        List<EmployeDTO> res = new ArrayList<EmployeDTO>();
        this.empService.findAll().stream().forEach((e) -> {
            res.add(new EmployeDTO(e));
        });
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/missions")
    public ResponseEntity<List<EmployeDTO>> findByMission(@RequestBody HashMap<String, String> patterns) {
        List<EmployeDTO> res = new ArrayList<EmployeDTO>();
        this.empService.findByMission(patterns.get("pattern")).stream().forEach((e) -> {
            res.add(new EmployeDTO(e));
        });
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findAll(@PathVariable("id") int id) {
        Optional<Employe> emp = this.empService.findById(id);
        if (emp.isPresent()) {
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
