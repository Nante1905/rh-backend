package com.example.restapi.model.employe;

import com.example.restapi.model.Service;
import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.contrat.Contrat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String matricule;
    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;
    @OneToOne
    @JoinColumn(name = "id_contrat")
    Contrat contrat;
    @Transient
    boolean isChef;

    public Employe(int id) {
        setId(id);
    }

    public Service getService() {
        return this.getContrat().getJob().getService();
    }
}
