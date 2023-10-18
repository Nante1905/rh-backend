package com.example.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.repositories.UtilisateurRepository;
import com.example.restapi.services.authentication.JWTManager;
import com.example.restapi.types.AuthClass;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository uRepository;

    @Autowired
    private JWTManager jwt;

    public void updateToEmploye(int id) {
        this.uRepository.updateRole(id, 3);
    }

    public Utilisateur save(Utilisateur u) {
        return this.uRepository.save(u);
    }

    public List<Utilisateur> findAll() {
        return this.uRepository.findAll();
    }

    public Optional<Utilisateur> findUtilisateurByUsername(String username) {
        return this.uRepository.findUtilisateurByUsername(username);
    }

    public Optional<Utilisateur> findUtilisateurByUsernameAndPassword(String username, String password) {
        return this.uRepository.findUtilisateurByUsernameAndPassword(username, password);
    }

    public String login(AuthClass user) throws Exception {
        // verify user in db
        Utilisateur utilisateur = findUtilisateurByUsernameAndPassword(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new Exception("Identifiants invalides"));
        return jwt.generateToken(utilisateur);
    }

    public Optional<Utilisateur> getAuthenticatedUser() {
        return this.uRepository
                .findUtilisateurByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public com.example.restapi.model.Service getAuhtenticatedService() throws Exception {
        Utilisateur current = getAuthenticatedUser().orElseThrow(() -> new Exception("No authenticated user"));
        System.out.println(current.getEmail());
        return current.getService();
    }
}
