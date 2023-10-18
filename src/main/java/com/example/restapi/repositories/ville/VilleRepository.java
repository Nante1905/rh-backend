package com.example.restapi.repositories.ville;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restapi.model.TypeContrat;
import com.example.restapi.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

}
