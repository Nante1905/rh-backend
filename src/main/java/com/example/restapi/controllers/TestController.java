package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.restapi.model.Question;
// import com.example.restapi.repositories.QuestionRepository;

@RestController
public class TestController {

    // @Autowired
    // private QuestionRepository questionRepository;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}
