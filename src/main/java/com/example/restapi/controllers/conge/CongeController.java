package com.example.restapi.controllers.conge;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.conge.DemandeConge;
import com.example.restapi.services.conge.CongeService;

@RestController
@RequestMapping("conges")
public class CongeController {

    @Autowired
    CongeService congeService;

    @GetMapping
    public ResponseEntity<List<DemandeConge>> findAll() {
        return ResponseEntity.ok().body(congeService.findAll());
    }

    @GetMapping("accept/{id}")
    public ResponseEntity<Object> accept(@PathVariable("id") int id) {
        HashMap<String, String> res = new HashMap<String, String>();
        try {
            this.congeService.acceptDemande(id);
            res.put("success", "true");
            res.put("msg", "success");
            return ResponseEntity.status(200).body(res);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("msg", e.getMessage());
            return ResponseEntity.status(500).body(res);
        }
    }

    @GetMapping("decline/{id}")
    public ResponseEntity<Object> decline(@PathVariable("id") int id) {
        HashMap<String, String> res = new HashMap<String, String>();
        try {
            this.congeService.refuseDemande(id);
            res.put("success", "true");
            res.put("msg", "success");
            return ResponseEntity.status(200).body(res);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("msg", e.getMessage());
            return ResponseEntity.status(500).body(res);
        }
    }
}
