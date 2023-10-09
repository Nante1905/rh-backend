package com.example.restapi.services.qcm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.restapi.model.qcm.Question;
import com.example.restapi.model.qcm.Questionnaire;
import com.example.restapi.repositories.qcm.QuestionRepository;
import com.example.restapi.repositories.qcm.QuestionnaireRepository;

@Component
@Service
public class QuestionnaireService {
    @Autowired
    QuestionnaireRepository qRepository;
    @Autowired
    QuestionRepository questionRepository;

    public Questionnaire findByIdJob(int idJob) throws Exception {
        List<Questionnaire> q = this.qRepository.findByIdJob(idJob);
        if (q.size() == 0) {
            return null;
        }

        Questionnaire res = q.get(0);
        res.getQuestions().stream().forEach((quest) -> {
            quest.getReponses().stream().forEach((r) -> {
                r.setValeur(false);
            });
        });
        // res.setQuestions(this.findQuestionsOf(res.getId()));
        return res;
    }

    public List<Questionnaire> findAllQuestionnaire() {
        return this.qRepository.findAll();
    }

    public List<Question> findQuestions(int id) {
        return this.questionRepository.findById(id);
        // return null;
    }
}
