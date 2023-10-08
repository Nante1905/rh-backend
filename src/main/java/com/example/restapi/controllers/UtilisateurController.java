package com.example.restapi.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.candidature.Candidature;
import com.example.restapi.services.CVService;
import com.example.restapi.services.CandidatureService;
import com.example.restapi.services.UtilisateurService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    UtilisateurService uService;
    @Autowired
    CVService cvService;

    @Autowired
    CandidatureService candidatureService;

    @GetMapping()
    public List<Utilisateur> findAll() {
        return this.uService.findAll();
    }

    @PostMapping(value = "sign")
    public Utilisateur signIn(@RequestBody Utilisateur u) {
        return this.uService.save(u);
    }

    @GetMapping("cv")
    public ResponseEntity<?> findAllCvOf() {
        HashMap<String, Object> res = new HashMap<>();
        try {
            res.put("OK", true);
            res.put("cv", this.cvService.findAllCvOf());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/candidatures")
    public ResponseEntity<?> findCandidatureOf() {
        HashMap<String, Object> res = new HashMap<>();
        List<HashMap<String, Object>> candidatures = new ArrayList<>();
        int i = 0;
        try {

            List<Candidature> dbRes = this.candidatureService.findForCurrentUser();
            for (Candidature c : dbRes) {
                HashMap<String, Object> can = new HashMap<>();
                can.put("job", c.getJob());
                can.put("status", c.getStatus());

                candidatures.add(can);
                i = i + 1;
            }

            res.put("candidatures", candidatures);
            res.put("OK", true);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
