package com.example.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.employe.Employe;
import com.example.restapi.repositories.EmployeRepository;
import com.example.restapi.repositories.UtilisateurRepository;
import com.example.restapi.services.authentication.JWTManager;
import com.example.restapi.types.AuthClass;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository uRepository;

    @Autowired
    private JWTManager jwt;

    @Autowired
    private EmployeRepository empRepository;

    public void updateToEmploye(int id) {
        this.uRepository.updateRole(id, 3);
    }

    public Utilisateur save(Utilisateur u) {
        return this.uRepository.save(u);
    }

    public List<Utilisateur> findAll() {
        return this.uRepository.findAll();
    }

    public Utilisateur findById(int id) {
        return this.uRepository.findById(id).get();
    }

    public Optional<Utilisateur> findUtilisateurByUsername(String username) {
        return this.uRepository.findUtilisateurByUsername(username);
    }

    public Optional<Utilisateur> findUtilisateurByUsernameAndPassword(String username, String password) {
        return this.uRepository.findUtilisateurByUsernameAndPassword(username, password);
    }

    public Employe findEmployeByUser(Utilisateur utilisateur) {
        return this.empRepository.findByUtilisateur(utilisateur);
    }

    public String login(AuthClass user) throws Exception {
        // verify user in db
        Utilisateur utilisateur = findUtilisateurByUsernameAndPassword(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new Exception("Identifiants invalides"));

        Employe employe = this.findEmployeByUser(utilisateur);
        return jwt.generateToken(utilisateur, employe);
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
