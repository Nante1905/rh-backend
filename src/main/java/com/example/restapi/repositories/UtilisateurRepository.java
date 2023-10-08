package com.example.restapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    // public Utilisateur save(Utilisateur u);
    public Optional<Utilisateur> findUtilisateurByUsername(String username);

    @Query(value = "select * from utilisateur where username=?1 and mot_de_passe=md5(?2)", nativeQuery = true)
    public Optional<Utilisateur> findUtilisateurByUsernameAndPassword(String username, String password);
}
