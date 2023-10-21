package com.example.restapi.model.employe;

import java.time.LocalDate;
import java.time.Period;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeDTO {
    int id;
    String matricule;
    String nom;
    String prenom;
    String genre;
    String poste;
    int age;
    String contrat;
    String anciennete;
    LocalDate debutContrat;
    String categorie;
    String service;

    public EmployeDTO(Employe source) {
        setId(source.getId());
        setMatricule(source.getMatricule());
        setNom(source.getUtilisateur().getNom());
        setPrenom(source.getUtilisateur().getPrenom());
        setGenre(source.getUtilisateur().getGenre().getNom());
        setAge(source.getUtilisateur().getAge());
        setContrat(source.getContrat().getType().getNom());
        setPoste(source.getContrat().getJob().getTitle());
        setCategorie(source.getContrat().getCategorie().getNom());
        Period period = source.getContrat().getAnciennete();
        setAnciennete(String.format("%dj %dm %da", period.getDays(), period.getMonths(), period.getYears()));
        setService(source.getService().getNom_service());
        setDebutContrat(source.getContrat().getDebut());
    }
}
