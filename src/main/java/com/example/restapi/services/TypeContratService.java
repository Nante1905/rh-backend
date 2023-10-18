package com.example.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.TypeContrat;
import com.example.restapi.repositories.typeContrat.TypeContratRepository;

import java.util.List;

@Service
public class TypeContratService {

    @Autowired
    private TypeContratRepository typeContratRepository;

    public List<TypeContrat> findAllTypeContrat() {
        return typeContratRepository.findAll();
    }
}
