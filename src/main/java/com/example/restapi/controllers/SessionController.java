package com.example.restapi.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.services.UtilisateurService;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/service")
    public ResponseEntity<?> getCurrentService() {
        HashMap<String, Object> res = new HashMap<>();
        try {
            res.put("OK", true);
            res.put("service", this.utilisateurService.getAuhtenticatedService());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }
}
