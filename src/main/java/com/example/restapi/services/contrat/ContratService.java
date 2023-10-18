package com.example.restapi.services.contrat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.contrat.Avantage;
import com.example.restapi.model.contrat.Categorie;
import com.example.restapi.model.contrat.Contrat;
import com.example.restapi.model.contrat.TypeContrat;
import com.example.restapi.repositories.contrat.AvantageRepo;
import com.example.restapi.repositories.contrat.CategorieRepo;
import com.example.restapi.repositories.contrat.ContratRepo;
import com.example.restapi.repositories.contrat.TypeContratRepo;
import com.example.restapi.services.UtilisateurService;

@Service
public class ContratService {
    @Autowired
    private TypeContratRepo typeContratRepo;
    @Autowired
    private AvantageRepo avantageRepo;
    @Autowired
    private ContratRepo contratRepo;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private CategorieRepo categorieRepo;

    public Optional<Contrat> findById(int id) {
        return this.contratRepo.findById(id);
    }

    public List<TypeContrat> findAllTypes() {
        return this.typeContratRepo.findAll();
    }

    public List<Avantage> findAllAvantages() {
        return this.avantageRepo.findAll();
    }

    public void save(Contrat contrat) throws Exception {
        this.contratRepo.save(contrat);
    }

    public List<Contrat> findPendingContratsOfUser() throws Exception {
        Utilisateur u = this.utilisateurService.getAuthenticatedUser()
                .orElseThrow(() -> new Exception("Not connected"));
        return this.contratRepo.findContratsByStatus(u.getId(), 0);
    }

    public List<Contrat> findAllContratOfUser() throws Exception {
        Utilisateur u = this.utilisateurService.getAuthenticatedUser()
                .orElseThrow(() -> new Exception("Not connected"));
        return this.contratRepo.findAllByIdUtilisateur(u.getId());
    }

    public List<Categorie> findAllCategorie() {
        return this.categorieRepo.findAll();
    }
}
