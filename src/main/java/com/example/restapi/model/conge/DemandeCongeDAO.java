package com.example.restapi.model.conge;

import java.time.LocalDate;

import com.example.restapi.model.employe.Employe;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DemandeCongeDAO {
    int id;
    int idEmp;
    String motif;
    TypeConge type;
    int codeStatus;
    String status;
    LocalDate debut;
    // boolean debutDemiJournee;
    LocalDate fin;
    // boolean finDemiJournee;

    public DemandeCongeDAO(DemandeConge source) {
        setId(source.getId());
        setIdEmp(source.getEmp().getId());
        setMotif(source.getMotif());
        setType(source.getType());
        setCodeStatus(source.getStatus());
        setDebut(source.getDebut());
        setFin(source.getFin());
    }

    public String getStatus() {
        if (codeStatus == -5) {
            return "Refusé";
        }
        if (codeStatus == 5) {
            return "Validé";
        }
        return "Attente";
    }
}
