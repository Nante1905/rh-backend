package com.example.restapi.controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.customException.FileException;
import com.example.restapi.model.candidature.dto.CandidatureDto;
import com.example.restapi.services.CandidatureService;
import com.example.restapi.services.FileService;

@RestController
@RequestMapping("/candidatures")
public class CandidatureController {
    @Autowired
    FileService fileService;

    @Autowired
    CandidatureService candidatureService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCandidatureStatus(@PathVariable(name = "id") int idCandidature,
            @RequestBody Map<String, Object> body) {
        HashMap<String, Object> res = new HashMap<>();
        int newStatus = (int) body.get("status");
        try {
            if (idCandidature <= 0 || newStatus < 0) {
                throw new Exception("No candidature or status supplied");
            }
            this.candidatureService.updateCandidatureStatus(idCandidature, newStatus);
            res.put("OK", true);
            res.put("message", "Candidature mis a jour");
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("message", e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(res);
        }
    }

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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CandidatureDto candidature) {
        HashMap<String, Object> res = new HashMap<>();
        System.out.println("debug ==================================== ");

        try {
            this.candidatureService.save(candidature);
            res.put("OK", true);
            res.put("message", "Candidature cree");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }
}
