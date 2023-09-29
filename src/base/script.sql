-- create database rh;
-- \c rh;

create table ville (
    id serial primary key,
    nom varchar(50)
);

create table utilisateur (
    id serial primary key,
    nom varchar(50) not null,
    prenom varchar(50),
    naissance date not null,
    email varchar(50) not null,
    telephone varchar(10),
    mdp varchar(20) not null,
    idville integer,
    foreign key(idville) references ville (id)
);

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
    nom varchar(100),
    valeur integer
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
    idJob integer,
    idDiplome integer,
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

create table cv (
    id serial primary key,
    idutilisateur integer not null,
    creation date,
    foreign key (idutilisateur) references utilisateur(id)
);