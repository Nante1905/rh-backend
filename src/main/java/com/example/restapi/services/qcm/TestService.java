package com.example.restapi.services.qcm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.qcm.test.ResultatCandidat;
import com.example.restapi.model.qcm.test.Test;
import com.example.restapi.repositories.qcm.ResultatCandidatRepository;
import com.example.restapi.repositories.qcm.TestRepository;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;
    @Autowired
    ResultatCandidatRepository resultatCandidatRepository;

    public Test save(Test test) {
        test.getReponses().stream().forEach((r) -> {
            r.setTest(test);
        });
        return this.testRepository.save(test);
    }

    public List<ResultatCandidat> findTestOf(int idJob) {
        return this.resultatCandidatRepository.findByIdJob(idJob);
    }
}
