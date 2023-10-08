package com.example.restapi.controllers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.customException.FileException;
import com.example.restapi.services.FileService;

@RestController
@RequestMapping("/candidatures")
public class CandidatureController {
    @Autowired
    FileService fileService;

    @GetMapping(path = "docs/{name}")
    @ResponseBody
    public ResponseEntity<Object> download(@PathVariable String name) {
        Resource file;
        try {
            file = fileService.load(name);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (FileException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
