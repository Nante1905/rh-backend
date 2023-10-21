package com.example.restapi.model.employe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "v_presence")
public class Presence {
    @Id
    int idEmploye;
    boolean presence;
    @OneToOne
    @JoinColumn(name = "id_employe")
    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnore
    Employe emp;

}
