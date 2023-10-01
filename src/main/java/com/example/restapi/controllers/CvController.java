package com.example.restapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.restapi.model.Nationalite;
import com.example.restapi.model.cv.DetailsCv;
import com.example.restapi.services.CVService;
import com.example.restapi.services.FileService;

@RestController
@RequestMapping(value = "/cv")
@CrossOrigin(origins = "*")
public class CvController {
    @Autowired
    CVService cvService;
    @Autowired
    FileService fileService;

    @GetMapping("{id}")
    public Optional<DetailsCv> find(@PathVariable(name = "id") int id) {
        System.out.println(id);
        return this.cvService.findById(id);
    }

    @GetMapping("")
    public List<DetailsCv> findAll() {
        return this.cvService.findAll();
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> uploadFile(@RequestParam("cv") MultipartFile cv,
            @RequestParam("certificat") MultipartFile certificat) {
        if (cv.isEmpty()) {
            System.out.println("vide lay fichier cv " + cv.getOriginalFilename());
            return ResponseEntity.badRequest().body("fichier invalide");
        }
        if (certificat.isEmpty()) {
            System.out.println("vide lay fichier certificat " + certificat.getOriginalFilename());
            return ResponseEntity.badRequest().body("fichier invalide");
        }
        try {
            System.out.println("trying upload");
            fileService.save(cv, null);
            fileService.save(certificat, null);
            return ResponseEntity.ok().body("Upload réussi");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    // @PostMapping(value = "/create", consumes = { "multipart/form-data" })
    // public ResponseEntity<Object> createCV(@RequestPart(name = "info") DetailsCv
    // cvInfo,
    // @RequestPart(value = "cv") MultipartFile cvFile, @RequestPart MultipartFile
    // certificat) {
    // System.out.println(">>>>>>>>>>>>>>>> " + cvInfo.toString());
    // try {
    // this.cvService.save(cvInfo, cvFile, certificat);
    // return ResponseEntity.status(200).body(new HashMap<String,
    // Object>().put("msg", "CV créé"));
    // } catch (FileAlreadyExistsException | FileException e) {
    // e.printStackTrace();
    // return ResponseEntity.status(500).body(new HashMap<String,
    // Object>().put("msg", e.getMessage()));
    // }
    // return ResponseEntity.ok().body("ok");
    // }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<HashMap<String, Object>> createCV(@RequestBody DetailsCv cv) {
        HashMap<String, Object> results = new HashMap<>();

        try {
            this.cvService.save(cv);
            results.put("OK", true);
            return new ResponseEntity<HashMap<String, Object>>(results, HttpStatus.OK);
        } catch (Exception e) {
            results.put("OK", false);
            results.put("message", e.getMessage());
            return new ResponseEntity<HashMap<String, Object>>(results, HttpStatus.OK);
        }
    }

    @PostMapping(value = "test")
    public ResponseEntity<Object> test(@RequestParam(name = "info") Nationalite info) {
        return ResponseEntity.ok().body(info);
    }

}
