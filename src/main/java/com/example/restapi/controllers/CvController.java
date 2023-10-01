package com.example.restapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.cv.DetailsCv;
import com.example.restapi.services.CVService;

@RestController
@RequestMapping(value = "/cv")
public class CvController {
    @Autowired
    CVService cvService;

    @GetMapping("{id}")
    public Optional<DetailsCv> find(@PathVariable(name = "id") int id) {
        System.out.println(id);
        return this.cvService.findById(id);
    }
}
