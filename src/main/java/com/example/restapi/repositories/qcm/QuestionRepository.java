package com.example.restapi.repositories.qcm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.Question;
import com.example.restapi.model.qcm.Reponse;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // public List<Question> findByIdQuestionnaire(int idQuestionnaire);
    List<Question> findById(int id);
}
