-- create database rh;
-- \c rh;

create table ville (
    id serial primary key,
    nom varchar(50)
);


CREATE TABLE sexe (
    idSexe SERIAL PRIMARY KEY,
    valeur INTEGER
);
CREATE TABLE nationalite (
    idNationalite SERIAL PRIMARY KEY,
    nationalite VARCHAR(20)
);

create table utilisateur (
    id serial primary key,
    nom varchar(50) not null,
    prenom varchar(50),
    naissance date not null,
    email varchar(50) not null,
    telephone varchar(10),
    mdp varchar(20) not null,
    id_ville integer,
    id_sexe integer not null,
    id_nationalite integer not null,
    foreign key(id_ville) references ville (id),
    foreign key(id_sexe) references sexe (idSexe),
    foreign key(id_nationalite) references nationalite (idNationalite)
);

CREATE TABLE service (
    id SERIAL PRIMARY KEY,
    nom_service VARCHAR(100)
);
CREATE TABLE job (
    id SERIAL PRIMARY KEY,
    title VARCHAR(256),
    volume INTEGER,
    man_day INTEGER,
    sal_min NUMERIC,
    sal_max NUMERIC,
    idService integer,
    FOREIGN KEY(idService) REFERENCES service(id)
);
-- MIALY V3: 

create table domaine (
    id serial primary key,
    nom varchar(200)
);

-- ---------------
CREATE TABLE diplome (
    idDiplome SERIAL PRIMARY KEY,
    nom varchar(100),
    valeur integer
);
CREATE TABLE sexe (
    idSexe SERIAL PRIMARY KEY,
    nom VARCHAR(20)
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
CREATE TABLE job_diplome (
    id_job integer,
    idDiplome integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(idDiplome) REFERENCES diplome(idDiplome)
);
CREATE TABLE job_sexe (
   id_job integer,
    idSexe integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(idSexe) REFERENCES sexe(idSexe)
);
CREATE TABLE job_matrimoniale (
    id_job integer,
    idMatrimoniale integer,\
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(idMatrimoniale) REFERENCES matrimoniale(idMatrimoniale)
);
CREATE TABLE job_experience (
    id_job integer,
    idExperience integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(idExperience) REFERENCES experience(idExperience)
);
CREATE TABLE job_nationalite (
    id_job integer,
    idNationalite integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(idNationalite) REFERENCES nationalite(idNationalite)
);

create table cv (
    id serial primary key,
    id_utilisateur integer not null,
    nom varchar(255),
    creation date default now(),
    foreign key (idutilisateur) references utilisateur(id)
);

-- alter table cv alter column creation set default now();

-- MIALY V3: 

create table domaine (
    id serial primary key,
    nom varchar(200)
);

create table cv_domaine (
    id_cv integer not null,
    id_domaine integer not null,
    foreign key (id_cv) references cv(id),
    foreign key (id_domaine) references domaine(id)
);

create table cv_diplome (
    id_cv integer not null,
    id_diplome integer not null,
    foreign key (id_cv) references cv(id),
    foreign key (id_diplome) references diplome(id_diplome)
);

create table cv_matrimonial (
    id_cv integer not null,
    id_matrimonial integer not null,
    foreign key (id_cv) references cv(id),
    foreign key (id_matrimonial) references matrimoniale(idMatrimoniale)
);

create table cv_experience (
    id_cv integer not null,
    id_experience integer not null,
    foreign key (id_cv) references cv(id),
    foreign key (id_experience) references experience(idExperience)
);

create table cv_fichier (
    id_cv integer not null,
    cv varchar(255) not null,
    certificat varchar(255) not null,
    foreign key (id_cv) references cv(id)
);

-- MIALY V4
create table questionnaire (
    id serial primary key,
    id_job integer not null,
    foreign key (id_job) references job(id)
);

create table question (
    id serial primary key,
    id_questionnaire integer not null,
    contenu text,
    coeff integer,
    foreign key (id_questionnaire) references questionnaire(id)
);

create table reponse (
    id serial primary key,
    id_question integer not null,
    contenu text,
    valeur boolean,
    foreign key(id_question) references question(id)
);
