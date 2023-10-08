package com.example.restapi.repositories.qcm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.test.Test;
import com.example.restapi.model.qcm.test.TestReponse;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findById(int id);
}
