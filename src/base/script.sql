CREATE DATABASE ressource_humaine;

\c ressource_humaine;

CREATE TABLE service (
    idService SERIAL PRIMARY KEY,
    nom_service VARCHAR(100)
);
CREATE TABLE job (
    idjob SERIAL PRIMARY KEY,
    title VARCHAR(20),
    volume INTEGER,
    man_day INTEGER,
    sal_min NUMERIC,
    sal_max NUMERIC,
    idService integer,
    FOREIGN KEY(idService) REFERENCES service(idService)
);
CREATE TABLE diplome (
    idDiplome SERIAL PRIMARY KEY,
<<<<<<< HEAD
    nom INTEGER
=======
    nom varchar(100),
    valeur integer
>>>>>>> 02f0de80d96250c9f9d1ba2f07cf08c9b53b0cd1
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
    idExperience SERIAL PRIMARY KEY,
    experience VARCHAR(20),
    valeur INTEGER
);
CREATE TABLE nationalite (
    idNationalite SERIAL PRIMARY KEY,
    nationalite VARCHAR(20)
);
CREATE TABLE job_diplome (
<<<<<<< HEAD
    idJob SERIAL,
    idDiplome INTEGER,
=======
    idJob integer,
    idDiplome integer,
>>>>>>> 02f0de80d96250c9f9d1ba2f07cf08c9b53b0cd1
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idDiplome) REFERENCES diplome(idDiplome)
);
CREATE TABLE job_sexe (
    idJob integer,
    idSexe integer,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idSexe) REFERENCES sexe(idSexe)
);
CREATE TABLE job_matrimoniale (
    idJob integer,
    idMatrimoniale integer,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idMatrimoniale) REFERENCES matrimoniale(idMatrimoniale)
);
CREATE TABLE job_experience (
    idJob integer,
    idExperience integer,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idExperience) REFERENCES experience(idExperience)
);
CREATE TABLE job_nationalite (
    idJob integer,
    idNationalite integer,
    coeff INTEGER,
    FOREIGN KEY(idJob) REFERENCES job(idJob),
    FOREIGN KEY(idNationalite) REFERENCES nationalite(idNationalite)
);
