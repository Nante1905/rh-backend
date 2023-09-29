package com.example.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository uRepository;

    public Utilisateur save(Utilisateur u) {
        return this.uRepository.save(u);
    }

    public List<Utilisateur> findAll() {
        return this.uRepository.findAll();
    }
}
