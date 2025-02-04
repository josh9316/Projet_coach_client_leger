DROP DATABASE IF EXISTS coaching_basket; 
CREATE DATABASE coaching_basket; 
USE coaching_basket; 

CREATE TABLE Coachs (
    idcoachs INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    specialite VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    tel VARCHAR(20) NOT NULL,
    Disponibilite VARCHAR(20) DEFAULT 'Disponible'  -- Ajout de la colonne pour le trigger
);

CREATE TABLE Club (
    idclub INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL,
    tel VARCHAR(20) NOT NULL,  -- Correction du type
    date_naissance DATE NOT NULL  -- Correction du type
);

CREATE TABLE Utilisateur (
    idutilisateur INT PRIMARY KEY AUTO_INCREMENT, 
    Nom VARCHAR(255) NOT NULL, 
    Type VARCHAR(50) NOT NULL,   
    Localisation VARCHAR(255) NOT NULL 
);

CREATE TABLE Exercice (
    idexercice INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    duree INT
);

CREATE TABLE Reservation (
    idReservation INT PRIMARY KEY AUTO_INCREMENT,  
    Utilisateur_ID INT NOT NULL,   
    Coach_ID INT NOT NULL, 
    Exercice_ID INT NOT NULL, 
    Date DATE NOT NULL,    
    Statut VARCHAR(50) NOT NULL,  
    FOREIGN KEY (Utilisateur_ID) REFERENCES Utilisateur(idutilisateur),
    FOREIGN KEY (Exercice_ID) REFERENCES Exercice(idexercice),
    FOREIGN KEY (Coach_ID) REFERENCES Coachs(idcoachs) 
);



/****** EVALUATION D'UN COACH ******/
CREATE TABLE Evaluation (
    idEvaluation INT PRIMARY KEY AUTO_INCREMENT,  
    Coach_ID INT NOT NULL,           
    Utilisateur_ID INT NOT NULL,      
    Note INT NOT NULL,             
    Commentaire TEXT,        
    FOREIGN KEY (Coach_ID) REFERENCES Coachs(idcoachs),    
    FOREIGN KEY (Utilisateur_ID) REFERENCES Utilisateur(idutilisateur)
);

CREATE TABLE user (
    iduser INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    mdp VARCHAR(255) NOT NULL,
    PRIMARY KEY (iduser)
);

/************** GESTION DE ABONNEMENT ************/

CREATE TABLE abonnements (
    idabonnement INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    date_abonnement DATETIME DEFAULT CURRENT_TIMESTAMP
);

/****** INSERTIONS CORRIGÉES ******/
INSERT INTO user (email, mdp) VALUES ("a@gmail.com", "123");
INSERT INTO user (email, mdp) VALUES ("b@gmail.com", "456");

------
/* VIEW :

CREATE VIEW vue_utilisateur_reservation AS
SELECT 
    u.Nom AS Utilisateur_Nom,
    c.Nom AS Coach_Nom,
    r.Date AS Date_Reservation,
    r.Statut AS Statut_Reservation,
    e.Note AS Note_Evaluation,
    e.Commentaire AS Commentaire_Evaluation
FROM 
    Utilisateur u
JOIN 
    Reservation r ON u.ID = r.Utilisateur_ID
JOIN 
    Coach c ON r.Coach_ID = c.ID
LEFT JOIN 
    Evaluation e ON c.ID = e.Coach_ID AND e.Utilisateur_ID = u.ID;


    Cette vue présente les utilisateurs, les coachs, les dates et le statut de leurs réservations,
     ainsi que la note et le commentaire de l'évaluation (si disponibles).
*/


/*TRIGGER :

DELIMITER $$

CREATE TRIGGER check_coach_availability_after_evaluation
AFTER INSERT ON Evaluation
FOR EACH ROW
BEGIN
    IF NEW.Note < 5 THEN
        UPDATE Coach
        SET Disponibilite = 'Indisponible'
        WHERE ID = NEW.Coach_ID;
    END IF;
END $$

DELIMITER ;


Ce trigger s'active après l'insertion d'une évaluation dans la table Evaluation.
Si la note insérée est inférieure à 5, la disponibilité du coach concerné est mise à jour et définie comme 'Indisponible'.
*/