DROP DATABASE IF EXISTS coaching_basket; 
CREATE DATABASE coaching_basket; 
USE coaching_basket; 

CREATE TABLE Coachs (
    idcoachs INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    Sexe Varchar (10) NOT NULL,
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

 

CREATE TABLE Exercice (
    idexercice INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    duree INT
);

CREATE TABLE Reservation (
    idreservation INT PRIMARY KEY AUTO_INCREMENT,  
    iduser INT NOT NULL,   
    idcoachs INT NOT NULL, 
    idexercice INT NOT NULL,
    idclub INT NOT NULL, 
    Date DATE NOT NULL,    
    Statut VARCHAR(50) NOT NULL,  
    FOREIGN KEY (idutilisateur) REFERENCES Utilisateur(idutilisateur),
    FOREIGN KEY (idexercice) REFERENCES Exercice(idexercice),
    FOREIGN KEY (idcoachs) REFERENCES Coachs(idcoachs),
    FOREIGN KEY (idclub) REFERENCES Club(idclub) 
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
    iduser INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
    
);

password_changed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP


/************** GESTION DE ABONNEMENT ************/

CREATE TABLE abonnements (
    idabonnement INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    date_abonnement DATETIME DEFAULT CURRENT_TIMESTAMP
);

select specialite, count(Utilisateur_ID) from coachs, Evaluation
where coachs.idcoachs = Evaluation.Coach_ID
group by specialite;

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