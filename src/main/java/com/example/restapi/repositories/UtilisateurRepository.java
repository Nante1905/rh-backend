package com.example.restapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    // public Utilisateur save(Utilisateur u);
    public Optional<Utilisateur> findUtilisateurByUsername(String username);

    @Query(value = "select * from utilisateur where username=?1 and mot_de_passe=md5(?2)", nativeQuery = true)
    public Optional<Utilisateur> findUtilisateurByUsernameAndPassword(String username, String password);

    @Modifying
    // @Query(value = "update utilisateur_role set id_role=?2 where
    // id_utilisateur=?1", nativeQuery = true)
    @Query(value = "insert into utilisateur_role (id_utilisateur, id_role) values (?1, ?2)", nativeQuery = true)
    public void updateRole(int id, int role);
}
