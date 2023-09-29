CREATE DATABASE ressource_humaine;

\c ressource_humaine;

CREATE TABLE service (
    idService SERIAL PRIMARY KEY,
    nom_service VARCHAR(20)
);
CREATE TABLE job (
    idjob SERIAL PRIMARY KEY,
    title VARCHAR(20),
    volume INTEGER,
    man_day INTEGER,
    sal_min NUMERIC,
    sal_max NUMERIC,
    idService SERIAL,
    FOREIGN KEY(idService) REFERENCES service(idService)
);
CREATE TABLE diplome (
    idDiplome SERIAL PRIMARY KEY,
    nom INTEGER
);
CREATE TABLE sexe (
    idSexe SERIAL PRIMARY KEY,
    valeur INTEGER
);
CREATE TABLE matrimoniale (
    idMatrimoniale SERIAL PRIMARY KEY,
    situation VARCHAR(20)
);
CREATE TABLE experience (
    idE SERIAL PRIMARY KEY,
    experience VARCHAR(20),
    valeur INTEGER
);
CREATE TABLE nationalite (
    idNationalite SERIAL PRIMARY KEY,
    nationalite VARCHAR(20)
);
CREATE TABLE job_diplome (
    idJob SERIAL,
    idDiplome INTEGER,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idDiplome) REFERENCES diplome(idDiplome)
);

CREATE TABLE job_matrimoniale (
    idJob INTEGER,
    idMatrimoniale SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idMatrimoniale) REFERENCES matrimoniale(idMatrimoniale)
);
CREATE TABLE job_experience (
    idJob INTEGER,
    idExperience SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idExperience) REFERENCES experience(idExperience)
);
CREATE TABLE job_nationalite (
    idJob INTEGER,
    idNationalite SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idNationalite) REFERENCES nationalite(idNationalite)
);
