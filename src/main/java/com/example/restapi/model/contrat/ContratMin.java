package com.example.restapi.model.contrat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratMin {
    int id;
    String poste;
    String type;

    public ContratMin() {
    }

    public ContratMin(Contrat source) {
        setId(source.getId());
        setPoste(source.getJob().getTitle());
        setType(source.getType().getNom());
    }

}
