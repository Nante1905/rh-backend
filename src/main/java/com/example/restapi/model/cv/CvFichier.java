package com.example.restapi.model.cv;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CvFichier {
    @Id
    int idCv;
    String cv;
    String certificat;

    public CvFichier() {
    }

    public CvFichier(String cv, String certificat) {
        setCv(cv);
        setCertificat(certificat);
    }

    public int getIdCv() {
        return idCv;
    }

    public void setIdCv(int idCv) {
        this.idCv = idCv;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

}
