package com.example.restapi.repositories.candidature;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.candidature.dto.CandidatureDto;

public interface CandidatureDtoRepository extends JpaRepository<CandidatureDto, Integer> {

}
