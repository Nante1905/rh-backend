package com.example.restapi.services.qcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.qcm.test.Test;
import com.example.restapi.model.qcm.test.TestReponse;
import com.example.restapi.repositories.qcm.TestRepository;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public Test save(Test test) {
        test.getReponses().stream().forEach((r) -> {
            r.setTest(test);
        });
        return this.testRepository.save(test);
    }
}
