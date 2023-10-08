-- create database rh;
-- \c rh;

create table ville (
    id serial primary key,
    nom varchar(50)
);


CREATE TABLE sexe (
    id SERIAL PRIMARY KEY,
    nom varchar(50)
);
CREATE TABLE nationalite (
    id SERIAL PRIMARY KEY,
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
    foreign key(id_sexe) references sexe (id),
    foreign key(id_nationalite) references nationalite (id)
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
    id_service integer,
    FOREIGN KEY(id_service) REFERENCES service(id)
);
-- MIALY V3: 

create table domaine (
    id serial primary key,
    nom varchar(200)
);

-- ---------------
CREATE TABLE diplome (
    id SERIAL PRIMARY KEY,
    nom varchar(100),
    valeur integer
);
-- CREATE TABLE sexe (
--     idSexe SERIAL PRIMARY KEY,
--     nom VARCHAR(20)
-- );
CREATE TABLE matrimonial (
    id SERIAL PRIMARY KEY,
    situation VARCHAR(20)
);
CREATE TABLE experience (
    id SERIAL PRIMARY KEY,
    experience VARCHAR(20),
    valeur INTEGER
);
CREATE TABLE job_diplome (
    id_job integer,
    id_diplome integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(id_diplome) REFERENCES diplome(id)
);
CREATE TABLE job_sexe (
    id_job integer,
    id_sexe integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(id_sexe) REFERENCES sexe(id)
);
CREATE TABLE job_matrimonial (
    id_job integer,
    id_matrimonial integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(id_matrimonial) REFERENCES matrimonial(id)
);
CREATE TABLE job_experience (
    id_job integer,
    id_experience integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(id_experience) REFERENCES experience(id)
);
CREATE TABLE job_nationalite (
    id_job integer,
    id_nationalite integer,
    coeff INTEGER,
    FOREIGN KEY(id_job) REFERENCES job(id),
    FOREIGN KEY(id_nationalite) REFERENCES nationalite(id)
);

create table cv (
    id serial primary key,
    id_utilisateur integer not null,
    nom varchar(255),
    creation date default now(),
    foreign key (id_utilisateur) references utilisateur(id)
);

-- alter table cv alter column creation set default now();

-- MIALY V3: 

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
    foreign key (id_diplome) references diplome(id)
);

create table cv_matrimonial (
    id_cv integer not null,
    id_matrimonial integer not null,
    foreign key (id_cv) references cv(id),
    foreign key (id_matrimonial) references matrimonial(id)
);

create table cv_experience (
    id_cv integer not null,
    id_experience integer not null,
    foreign key (id_cv) references cv(id),
    foreign key (id_experience) references experience(id)
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

-- POUR SELECTION DOSSIER
alter table job_diplome add column id_domaine integer;
alter table job_diplome add foreign key(id_domaine) references domaine(id);

create table candidature(
    id serial primary key,
    id_job integer not null,
    id_cv integer not null,
    depot date not null default now() ,
    foreign key (id_job) references job(id),
    foreign key (id_cv) references cv(id)
);

alter table job add column jour date default now();
alter table cv_fichier rename column cv to diplome;

-- MODULE TEST
create table test (
    id serial primary key,
    id_questionnaire integer not null references questionnaire(id),
    jour date not null default now()
);

create table test_reponse (
    id serial primary key,
    id_test integer not null references test(id),
    id_question integer not null references question(id),
    id_reponse integer not null references reponse(id),
    valeur boolean not null default false
);
-- Nante: auth module
create table role (
    id serial primary key,
    nom varchar(100)
);

create table utilisateur_role (
    id serial primary key,
    id_role int references role(id),
    id_utilisateur int references utilisateur(id)
);

alter table utilisateur add username varchar(200) unique;
alter table utilisateur add mot_de_passe text;

-- form fixing and dynamic
alter table utilisateur add id_service int references service(id);

-- update table candidature
-- 0->en attente, 1->test, 2->entretien, 3->embauche
alter table candidature add status int;
alter table utilisateur drop column mdp;
