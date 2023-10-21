package com.example.restapi.repositories.conge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.conge.DemandeConge;
import com.example.restapi.model.employe.Employe;

public interface CongeRepository extends JpaRepository<DemandeConge, Integer> {

    @Modifying
    @Query(value = "update demande_conge set status = ?2 where id = ?1 ", nativeQuery = true)
    public void updateStatus(int id, int status);

    @Query(value = "select * from v_demande_conge_categorie where valeur < ?1 and status=0", nativeQuery = true)
    public List<DemandeConge> findAllDemandeCongeUnder(int categorieValeur);

    public List<DemandeConge> findByEmp(Employe emp);
}
