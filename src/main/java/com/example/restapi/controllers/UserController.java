package com.example.restapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Employe;
import com.example.restapi.repositories.EmployeRepository;

@RestController
public class UserController {

    @Autowired
    private EmployeRepository employeRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/")

    public List<Employe> getEmployes() {
        List<Employe> emps = this.employeRepository.findAll();
        List<Employe> filtered = emps.stream()
                .filter(employe -> employe.getId() > 1)
                .collect(Collectors.toList());

        return filtered;
    }
}
