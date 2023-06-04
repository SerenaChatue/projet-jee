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
    (1, 'UTILISATEUR'),
    (2, 'UTILISATEUR'),
    (3, 'UTILISATEUR'),
    (4, 'UTILISATEUR'),
    (5, 'UTILISATEUR');

-- Insertion de données dans la table "utilisateur"
INSERT INTO utilisateur (IdCompte, NomUtilisateur, PrenomUtilisateur) VALUES
	(1, 'Doe', 'John'),
   	(2, 'Smith', 'Jane'),
   	(3, 'Johnson', 'Mark'),
   	(4, 'Taylor', 'Emily'),
   	(5, 'Brown', 'Michael');

-- Insertion de données dans la table "amitie"
INSERT INTO amitie (sender_id, receiver_id, demande_envoyee, demande_acceptee) VALUES
	(1, 2, true, false),
   	(1, 4, true, true),
   	(3, 1, true, false),
   	(4, 2, true, true),
   	(5, 1, true, true);

-- Insertion de données dans la table "auteur"
INSERT INTO auteur (NomAuteur) VALUES
	('Auteur1'),
	('Auteur2'),
	('Auteur3'),
	('John Smith'),
	('Jane Doe');

-- Insertion de données dans la table "editeur"
INSERT INTO editeur (NomEditeur) VALUES
	('Editeur1'),
	('Editeur2'),
	('Editeur3'),
	('PublisherX'),
	('PublisherY');

-- Insertion de données dans la table "categorie"
INSERT INTO categorie (Libelle) VALUES
	('Catégorie1'),
	('Catégorie2'),
	('Catégorie3'),
	('GenreA'),
	('GenreB');

-- Insertion de données dans la table "ouvrage"
INSERT INTO ouvrage (IdCompte, IdAuteur, IdEditeur, NomOuvrage, IdCategorie) VALUES
	(1, 1, 1, 'Ouvrage1', 1),
	(2, 2, 2, 'Ouvrage2', 2),
	(1, 3, 3, 'Ouvrage3', 3),
	(3, 4, 4, 'BookX', 4),
	(4, 5, 5, 'BookY', 5);

-- Insertion de données dans la table "emprunt"
-- INSERT INTO emprunt (IdOuvrage, IdCompte, IdAmi, DateEmprunt, Delai) VALUES
--	(1, 1, 4, '2023-01-01', 7),
--	(2, 2, 2, '2023-02-01', 14),
--	(3, 3, 3, '2023-03-01', 21),
--	(4, 4, 4, '2023-04-01', 7),
--	(5, 5, 5, '2023-05-01', 14);
