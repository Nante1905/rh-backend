package com.example.restapi.repositories.qcm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {

}