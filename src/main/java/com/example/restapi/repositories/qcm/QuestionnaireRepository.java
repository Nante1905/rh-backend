package com.example.restapi.repositories.qcm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {
    public List<Questionnaire> findByIdJob(int idJob);
}
