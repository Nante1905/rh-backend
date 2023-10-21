package com.example.restapi.repositories.qcm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.qcm.test.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findById(int id);
}
