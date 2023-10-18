package com.example.restapi.controllers.contrat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.contrat.Categorie;
import com.example.restapi.model.contrat.Contrat;
import com.example.restapi.model.contrat.ContratMin;
import com.example.restapi.services.contrat.ContratService;

@RestController
@RequestMapping("contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) throws Exception {
        Optional<Contrat> contrat = this.contratService.findById(id);
        if (contrat.isPresent()) {
            return ResponseEntity.ok().body(contrat.get());
        }
        return ResponseEntity.status(404).body("Contrat not found");
    }

    @GetMapping("/utilisateurs")
    public List<ContratMin> findAllContratOfAuthenticatedUser() throws Exception {
        List<ContratMin> res = new ArrayList<ContratMin>();
        this.contratService.findAllContratOfUser().stream().forEach((c) -> {
            res.add(new ContratMin(c));
        });
        return res;
    }

    @GetMapping("/utilisateurs/pending")
    public List<ContratMin> findAllPendingContratOfAuthenticatedUser() throws Exception {
        List<ContratMin> res = new ArrayList<ContratMin>();
        this.contratService.findPendingContratsOfUser().stream().forEach((c) -> {
            res.add(new ContratMin(c));
        });
        return res;
    }

    @GetMapping("/categories")
    public List<Categorie> findAllCategorie() throws Exception {
        return this.contratService.findAllCategorie();
    }

    @PostMapping("")
    public void insert(@RequestBody Contrat contrat) throws Exception {
        this.contratService.save(contrat);
    }

    @GetMapping("/types")
    public ResponseEntity<?> findAllTypes() {
        HashMap<String, Object> res = new HashMap<>();
        try {
            res.put("OK", true);
            res.put("data", this.contratService.findAllTypes());
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());
            return ResponseEntity.ok().body(res);
        }
    }

    @GetMapping("/avantages")
    public ResponseEntity<?> findAllAvantages() {
        HashMap<String, Object> res = new HashMap<>();
        try {
            res.put("OK", true);
            res.put("data", this.contratService.findAllAvantages());
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("OK", false);
            res.put("err", e.getMessage());
            return ResponseEntity.ok().body(res);
        }
    }

}
