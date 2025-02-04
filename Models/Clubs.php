<?php
require_once("Database.php");

class Clubs {
    private $unPdo;

    public function __construct() {
        $db = new Database();
        $this->unPdo = $db->getConnection();
    }

    public function selectAllClubs() {
        $requete = "SELECT * FROM Club;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute();
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }

    public function insertClub($tab) {
        $requete = "INSERT INTO Club (nom, adresse, email, tel, date_naissance) 
                    VALUES (:nom, :adresse, :email, :tel, :date_naissance);";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute($tab);
    }

    public function selectWhereClub($idclub) {
        $requete = "SELECT * FROM Club WHERE idclub = :idclub;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idclub" => $idclub]);
        return $exec->fetch(PDO::FETCH_ASSOC);
    }

    public function updateClub($tab) {
        $requete = "UPDATE Club SET nom = :nom, adresse = :adresse, email = :email, tel = :tel, date_naissance = :date_naissance 
                    WHERE idclub = :idclub;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute($tab);
    }

    public function selectLikeClubs($filtre){
        $requete = "SELECT * FROM club WHERE 
            nom LIKE :filtre OR 
            prenom LIKE :filtre OR 
            adresse LIKE :filtre OR 
            email LIKE :filtre OR 
            tel LIKE :filtre;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":filtre" => "%".$filtre."%"]);
        return $exec->fetchAll();
    }
    
    public function deleteClub($idclub) {
        $requete = "DELETE FROM Club WHERE idclub = :idclub;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idclub" => $idclub]);
    }
}
?>