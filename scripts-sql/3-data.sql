--SET search_path TO projet;


-- Supprime toutes les données
DELETE FROM role;
DELETE FROM compte;
DELETE FROM Utilisateur;



-- Insère les données

INSERT INTO compte (Pseudo, MotDePasse, Email) VALUES
    ('user1', 'pass1', 'user1@example.com'),
    ('user2', 'pass2', 'user2@example.com'),
    ('user3', 'pass3', 'user3@example.com'),
    ('user4', 'pass4', 'user4@example.com'),
    ('user5', 'pass5', 'user5@example.com');
    ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 6;


-- Jeu de données pour la table "role"
INSERT INTO role (IdCompte, Role) VALUES
    (1, 'ADMINISTRATEUR'),
    (2, 'UTILISATEUR'),
    (3, 'UTILISATEUR'),
    (4, 'UTILISATEUR'),
    (5, 'UTILISATEUR');

-- Jeu de données pour la table "utilisateur"
INSERT INTO utilisateur (IdCompte, NomUtilisateur, PrenomUtilisateur) VALUES
    (1, 'Doe', 'John'),
    (2, 'Smith', 'Jane'),
    (3, 'Johnson', 'Mark'),
    (4, 'Williams', 'Emily'),
    (5, 'Brown', 'Michael');

-- Jeu de données pour la table "auteur"
INSERT INTO auteur (NomAuteur) VALUES
    ('Dupont'),
    ('Martin'),
    ('Lefebvre'),
    ('Rousseau'),
    ('Gagnon');
    
-- Jeu de données pour la table "editeur"
INSERT INTO editeur (NomEditeur) VALUES
    ('Éditions ABC'),
    ('Éditions XYZ'),
    ('Éditions JKL');

-- Jeu de données pour la table "categorie"
INSERT INTO categorie (idcategorie, libelle) VALUES
    (1, 'Roman'),
    (2, 'Poesie');
    
-- Jeu de données pour la table "ouvrage"
INSERT INTO ouvrage (IdCompte, IdAuteur, IdEditeur, NomOuvrage, IdCategorie) VALUES
    (1, 1, 1, 'Livre 1', 1),
    (2, 2, 2, 'Poème 1', 2),
    (3, 3, 1, 'Livre 2', 1),
    (4, 4, 2, 'Poème 2', 2),
    (5, 5, 3, 'Livre 3', 1);

-- Jeu de données pour la table "emprunt"
INSERT INTO emprunt (IdOuvrage, IdCompte, DateEmprunt) VALUES
 	(1, 1, '2023-05-01'),
    (2, 2, '2023-05-02'),
    (3, 3, '2023-05-03'),
    (4, 4, '2023-05-04'),
    (5, 5, '2023-05-05');

