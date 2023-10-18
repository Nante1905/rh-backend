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
    id_candidature integer not null references candidature(id),
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

-- Bidy : modif job
alter table job add id_type_contrat integer;
alter table job add nbr_personne integer;
alter table job add min_age integer;
alter table job add max_age integer;
alter table job add id_ville integer;
alter table job add foreign key(id_type_contrat) references type_contrat(id);
alter table job add foreign key(id_ville) references ville(id);
alter table job add man_day integer;
alter table job add mission VARCHAR(300);
--ALTER TABLE job DROP COLUMN man_day;



-- CONTRAT 

create table type_contrat (
    id serial primary key,
    nom varchar(100)
);



CREATE TABLE avantage (
    id serial primary key,
    nom varchar(250)
);
insert into avantage (nom) VALUES 
('Assurance santé'),
('Logement'),
('Vehiculé');

create table contrat (
    id serial primary key,
    id_utilisateur int references utilisateur(id),
    id_job int references job(id),
    id_type_contrat int references type_contrat(id),
    salaire_brut numeric,
    date_debut date,
    date_fin date
);

create table contrat_avantage (
    id serial primary key,
    id_contrat int references contrat(id),
    id_avantage int references avantage(id)
);

create table categorie (
    id serial primary key,
    nom varchar(200),
    valeur int
);

alter TABLE contrat add id_categorie int references categorie(id);
alter table contrat add creation date default now();
-- 0 -> crée, 3 -> accepter, -3 -> refuser
alter table contrat add status int;

-- EMPLOYE =============
create table employe (
    id serial primary key,
    matricule varchar(10) unique not null,
    id_utilisateur integer not null references utilisateur(id),
    id_contrat integer not null references contrat(id)
);