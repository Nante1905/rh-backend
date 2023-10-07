package com.example.restapi.model.cv;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CvFichier {
    @Id
    int idCv;
    String diplome;
    String certificat;

    public CvFichier() {
    }

    public CvFichier(String diplome, String certificat) {
        setDiplome(diplome);
        setCertificat(certificat);
    }

    public int getIdCv() {
        return idCv;
    }

    public void setIdCv(int idCv) {
        this.idCv = idCv;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

}
