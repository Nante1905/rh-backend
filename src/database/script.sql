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