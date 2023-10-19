package com.example.restapi.model.employe;

import java.time.LocalDate;

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
        setAnciennete(source.getContrat().getAnciennete());
        setDebutContrat(source.getContrat().getDebut());
    }
}
