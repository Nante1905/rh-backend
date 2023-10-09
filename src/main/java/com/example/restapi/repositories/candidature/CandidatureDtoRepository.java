package com.example.restapi.repositories.candidature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.candidature.dto.CandidatureDto;

import jakarta.transaction.Transactional;

public interface CandidatureDtoRepository extends JpaRepository<CandidatureDto, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update candidature set status=?2 where id=?1", nativeQuery = true)
    public void updateCandidatureStatus(int idCandidature, int newStatus);
}
