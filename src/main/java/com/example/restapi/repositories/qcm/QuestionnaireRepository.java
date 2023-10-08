package com.example.restapi.repositories.qcm;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.Questionnaire;
import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {
    public List<Questionnaire> findByIdJob(int idJob);
}
