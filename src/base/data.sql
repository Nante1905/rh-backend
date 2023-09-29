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

INSERT INTO utilisateur (nom, prenom, naissance, telephone, email, mdp, idville) VALUES
    ('Razafindramanitra', 'Mireille', '1990-03-15', '0321234567', 'mireille@gmail.com', 'Mireille', 1, 2),
    ('Rakotoarison', 'Andry', '1985-06-20', '0342345678', 'andry@gmail.com', 'Andry', 1, 1),
    ('Rasolondraibe', 'Feno', '1992-09-30', '0333456789', 'feno@gmail.com', 'Feno', 2, 1),
    ('Rajaonarison', 'Tsiry', '1988-12-12', '0324567890', 'tsiry@gmail.com', 'Tsiry', 2);

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
INSERT INTO matrimoniale (situation) VALUES
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

    INSERT INTO sexe (nom) values 
    ('Homme'),
    ('Femme');

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