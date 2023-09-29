create table questonnaire (
    id serial primary key,
    nom varchar(250),
    date_creation date
);

create table question (
    id serial primary key,
    id_questionnaire integer references(questionnaire.id),
    texte text,
    coeff integer
);

create table reponse (
    id serial primary key,
    id_question integer references(question.id),
    texte text,
    valeur boolean
);