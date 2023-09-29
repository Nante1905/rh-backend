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
    idJob SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob)
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
    idDiplome SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idDiplome) REFERENCES diplome(idDiplome)
);
CREATE TABLE job_sexe (
    idJob SERIAL,
    idSexe SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idSexe) REFERENCES sexe(idSexe)
);
CREATE TABLE job_matrimoniale (
    idJob SERIAL,
    idMatrimoniale SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idMatrimoniale) REFERENCES matrimoniale(idMatrimoniale)
);
CREATE TABLE job_experience (
    idJob SERIAL,
    idExperience SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idExperience) REFERENCES experience(idExperience)
);
CREATE TABLE job_nationalite (
    idJob SERIAL,
    idNationalite SERIAL,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idNationalite) REFERENCES nationalite(idNationalite)
);
