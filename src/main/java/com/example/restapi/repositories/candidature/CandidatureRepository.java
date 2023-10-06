package com.example.restapi.repositories.candidature;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {

    @Query(value = "SELECT * FROM candidature c WHERE c.id_job = :idJob order by depot asc", nativeQuery = true)
    public List<Candidature> findByIdJob(int idJob);

}
