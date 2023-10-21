package com.example.restapi.model.conge;

import java.time.LocalDate;

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
    String employe;
    String service;
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
        setEmploye(source.getEmp().getUtilisateur().getNom() + " " + source.getEmp().getUtilisateur().getPrenom());
        setService(source.getEmp().getContrat().getJob().getService().getNom_service());
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
