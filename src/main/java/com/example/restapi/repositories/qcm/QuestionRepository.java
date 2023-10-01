package com.example.restapi.repositories.qcm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
