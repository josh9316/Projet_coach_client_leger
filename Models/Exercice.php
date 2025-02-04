<?php
require_once("Database.php");

class Exercice {
    private $unPdo;

    public function __construct() {
        $db = new Database();
        $this->unPdo = $db->getConnection();
    }

    public function selectAllExercices() {
        $requete = "SELECT * FROM exercice;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute();
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }

    public function insertExercice($tab) {
        $requete = "INSERT INTO exercice (nom, description, duree) VALUES (:nom, :description, :duree);";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([
            ":nom" => $tab['nom'],
            ":description" => $tab['description'],
            ":duree" => $tab['duree']
        ]);
    }

    public function selectWhereExercice($idexercice) {
        $requete = "SELECT * FROM exercice WHERE idexercice = :idexercice;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idexercice" => $idexercice]);
        return $exec->fetch(PDO::FETCH_ASSOC);
    }

    public function updateExercice($tab) {
        $requete = "UPDATE exercice SET nom = :nom, description = :description, duree = :duree WHERE idexercice = :idexercice;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([
            ":nom" => $tab['nom'],
            ":description" => $tab['description'],
            ":duree" => $tab['duree'],
            ":idexercice" => $tab['idexercice']
        ]);
    }

    public function deleteExercice($idexercice) {
        $requete = "DELETE FROM exercice WHERE idexercice = :idexercice;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idexercice" => $idexercice]);
    }

    public function selectLikeExercices($filtre) {
        $requete = "SELECT * FROM exercice WHERE nom LIKE :filtre OR description LIKE :filtre;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":filtre" => "%" . $filtre . "%"]);
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>
