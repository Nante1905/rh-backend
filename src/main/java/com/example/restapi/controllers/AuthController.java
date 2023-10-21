package com.example.restapi.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.services.UtilisateurService;
import com.example.restapi.types.AuthClass;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthClass user) {
        HashMap<String, Object> res = new HashMap<>();
        System.out.println(user.getUsername());
        try {
            res.put("OK", true);
            res.put("token", utilisateurService.login(user));

            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }
}
