package com.example.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Ville;
import com.example.restapi.repositories.ville.VilleRepository;

import java.util.List;

@Service
public class VilleService {

    @Autowired
    private VilleRepository ville;

    
    public List<Ville> findAllVille() {
        return ville.findAll();
    }

}
