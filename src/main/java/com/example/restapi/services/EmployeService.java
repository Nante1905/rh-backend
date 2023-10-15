package com.example.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.employe.Employe;
import com.example.restapi.repositories.EmployeRepository;

@Service
public class EmployeService {

    @Autowired
    EmployeRepository empRepository;

    public String generateMatricule() {
        long count = this.empRepository.count();
        return "E" + String.format("%04d", count + 1);
    }

    public Employe save(Employe e) {
        e.setMatricule(this.generateMatricule());
        return this.empRepository.save(e);
    }

    public List<Employe> findAll() {
        return this.empRepository.findAll();
    }
}
