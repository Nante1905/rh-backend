INSERT INTO ville (nom) VALUES
    ('Antananarivo'),
    ('Antsirabe'),
    ('Toamasina'),
    ('Fianarantsoa'),
    ('Mahajanga'),
    ('Toliara'),
    ('Antsiranana'),
    ('Morondava'),
    ('Ambanja'),
    ('Manakara'),
    ('Ambositra'),
    ('Ambatondrazaka'),
    ('Fort Dauphin'),
    ('Miandrivazo'),
    ('Tsiroanomandidy'),
    ('Maroantsetra'),
    ('Tôlanaro'),
    ('Vangaindrano'),
    ('Antsohihy'),
    ('Antalaha');
INSERT INTO sexe (nom) values 
    ('Homme'),
    ('Femme');


INSERT INTO service (nom_service) VALUES
    ('Direction des Ressources Humaines'),
    ('Direction Financière'),
    ('Direction de la Technologie de l''Information'),
    ('Direction des Ventes');

INSERT INTO diplome (nom, valeur) VALUES
    ('Baccalauréat', 1),
    ('Licence', 2),
    ('Master', 3),
    ('Doctorat', 4);
INSERT INTO matrimonial (situation) VALUES
    ('Célibataire'),
    ('Marié'),
    ('Divorcé'),
    ('Veuf');

INSERT INTO experience (experience, valeur) VALUES
    ('1-3 ans', 1),
    ('4-6 ans', 2),
    ('6 ans+', 3);

    INSERT INTO nationalite (nationalite) VALUES
    ('Etranger'),
    ('National');


INSERT INTO domaine (nom) VALUES
    ('Informatique'),
    ('Sciences économiques'),
    ('Médecine'),
    ('Droit'),
    ('Physique'),
    ('Psychologie'),
    ('Mathématiques'),
    ('Sciences politiques'),
    ('Biologie'),
    ('Arts plastiques');

INSERT INTO utilisateur (nom, prenom, naissance, telephone, email, mdp, id_ville, id_nationalite, id_sexe) VALUES
    ('Razafindramanitra', 'Mireille', '1990-03-15', '0321234567', 'mireille@gmail.com', 'Mireille', 3, 2,1),
    ('Rakotoarison', 'Andry', '1985-06-20', '0342345678', 'andry@gmail.com', 'Andry', 3, 1,2),
    ('Rasolondraibe', 'Feno', '1992-09-30', '0333456789', 'feno@gmail.com', 'Feno', 2, 2,1),
    ('Rajaonarison', 'Tsiry', '1988-12-12', '0324567890', 'tsiry@gmail.com', 'Tsiry', 2, 1,2);

INSERT into role (nom) values
('ADMIN'),
('PUBLIC'),
('EMPLOYE');

insert into utilisateur_role (id_role, id_utilisateur) values 
(1, 1);

UPDATE utilisateur set username='test' where id=1;
UPDATE utilisateur set mot_de_passe=MD5('test') where id=1;

insert into type_contrat (type_contrat) values
('CDI'),
('CDD'),
('CTT');