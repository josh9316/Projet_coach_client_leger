<?php
require_once("Database.php");

class Coachs {
    private $unPdo;

    public function __construct() {
        $db = new Database();
        $this->unPdo = $db->getConnection();
    }

    public function selectAllCoachs() {
        $requete = "SELECT * FROM Coachs;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute();
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }

    public function selectWhereCoach($idcoach) {
        $requete = "SELECT * FROM Coachs WHERE idcoachs = :idcoachs;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idcoachs" => $idcoach]);
        return $exec->fetch(PDO::FETCH_ASSOC);
    }

    public function selectLikeCoachs($filtre) {
        $requete = "SELECT * FROM Coachs 
                    WHERE nom LIKE :filtre 
                    OR prenom LIKE :filtre 
                    OR specialite LIKE :filtre 
                    OR email LIKE :filtre 
                    OR tel LIKE :filtre;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":filtre" => "%" . $filtre . "%"]);
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }

    public function insertCoach($tab) {
        $requete = "INSERT INTO Coachs (nom, prenom, specialite, email, tel) 
                    VALUES (:nom, :prenom, :specialite, :email, :tel);";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([
            ":nom" => $tab['nom'],
            ":prenom" => $tab['prenom'],
            ":specialite" => $tab['specialite'],
            ":email" => $tab['email'],
            ":tel" => $tab['tel']
        ]);
    }

    public function updateCoach($tab) {
        $requete = "UPDATE Coachs SET nom = :nom, prenom = :prenom, specialite = :specialite, email = :email, tel = :tel 
                    WHERE idcoachs = :idcoach;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([
            ":nom" => $tab['nom'],
            ":prenom" => $tab['prenom'],
            ":specialite" => $tab['specialite'],
            ":email" => $tab['email'],
            ":tel" => $tab['tel'],
            ":idcoach" => $tab['idcoach']
        ]);
    }

    public function deleteCoach($idcoach) {
        $requete = "DELETE FROM Coachs WHERE idcoachs = :idcoach;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idcoach" => $idcoach]);
    }
}
?>
