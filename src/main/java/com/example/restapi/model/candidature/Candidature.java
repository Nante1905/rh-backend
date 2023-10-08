package com.example.restapi.model.candidature;

import java.time.LocalDate;

import com.example.restapi.model.cv.DetailsCv;
import com.example.restapi.model.job.JobDetail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    // int idJob;
    // int idCv;
    LocalDate depot;
    @ManyToOne
    @JoinColumn(name = "id_cv", insertable = false)
    DetailsCv cv;
    @ManyToOne
    @JoinColumn(name = "id_job", insertable = false)
    JobDetail job;
    @Transient
    double note;

    int status;

    public Candidature() {
    }

    public void processNote() {
        double note = 0;
        // diplome et domaine
        if (this.getCv().getDomaine().getDomaine().getId() == this.getJob().getJobDiplome().getDomaine().getId()) {
            note += this.getCv().getDiplome().getDiplome().getValeur() *
                    this.getJob().getJobDiplome().getCoeff();
            if (this.getCv().getDiplome().getDiplome().isSup(this.getJob().getJobDiplome().getDiplome().getValeur())) {
                this.getCv().getDiplome().setValide(true);
                System.out.println("Valide ny diplome " + this.getCv().getDiplome().isValide());
            }
        }

        // experience
        if (this.getCv().getExperience().getExperience()
                .isSup(this.getJob().getJobExperience().getExperience().getValeur())) {
            note += this.getCv().getExperience().getExperience().getValeur();
            this.getCv().getExperience().setValide(true);
            System.out.println("Valide ny exp");
        }

        // genre
        this.getCv().getUtilisateur().getGenre().setValide(
                this.getCv().getUtilisateur().getGenre().getId() == this.getJob().getJobSexe().getGenre().getId());
        if (this.getCv().getUtilisateur().getGenre().isValide()) {
            note += this.getJob().getJobSexe().getCoeff();
            System.out.println("Valide ny genre");
        }

        // nationalite
        this.getCv().getUtilisateur().getNationalite().setValide(this.getCv().getUtilisateur().getNationalite()
                .getId() == this.getJob().getJobNationalite().getNationalite().getId());
        if (this.getCv().getUtilisateur().getNationalite().isValide()) {
            note += this.getJob().getJobNationalite().getCoeff();
            System.out.println("Valide ny nationalite");
        }

        // matrimoniale
        this.getCv().getMatrimonial().getMatrimonial().setValide(this.getCv().getMatrimonial().getMatrimonial()
                .getId() == this.getJob().getJobMatrimoniale().getMatrimonial().getId());
        if (this.getCv().getMatrimonial().getMatrimonial().isValide()) {
            note += this.getJob().getJobMatrimoniale().getCoeff();
            System.out.println("Valide ny matrimoniale");
        }

        System.out.println("Total " + note);
        setNote(note);
        // return note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDepot() {
        return depot;
    }

    public void setDepot(LocalDate depot) {
        this.depot = depot;
    }

    public JobDetail getJob() {
        return job;
    }

    public void setJob(JobDetail job) {
        this.job = job;
    }

    public void setCv(DetailsCv cv) {
        this.cv = cv;
    }

    public DetailsCv getCv() {
        return this.cv;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public double getNote() {
        return note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
