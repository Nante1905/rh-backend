package com.example.restapi.repositories.qcm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.qcm.test.ResultatCandidat;

public interface ResultatCandidatRepository extends JpaRepository<ResultatCandidat, Integer> {
    // @Query(value = "select * from v_test_note_job where id_job = :idJob",
    // nativeQuery = true)
    // public List<ResultatCandidat> findByIdJob(int idJob);
    List<ResultatCandidat> findByIdJob(int id_job);
}
