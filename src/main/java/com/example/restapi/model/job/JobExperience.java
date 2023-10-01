package com.example.restapi.model.job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JobExperience {
    @Id
    @Column(name = "idjob")
    int idJob;

}
