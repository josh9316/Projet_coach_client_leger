<?php
require_once("Database.php");

class Abonnement {
    private $unPdo;

    public function __construct() {
        $db = new Database();
        $this->unPdo = $db->getConnection();
    }

    public function insertAbonnement($email) {
        $requete = "INSERT INTO abonnements (email) VALUES (:email);";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":email" => $email]);
    }

    public function checkAbonnement($email) {
        $requete = "SELECT * FROM abonnements WHERE email = :email;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":email" => $email]);
        return $exec->fetch(PDO::FETCH_ASSOC);
    }

    public function deleteAbonnement($email) {
        $requete = "DELETE FROM abonnements WHERE email = :email;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":email" => $email]);
    }

    public function selectAllAbonnements() {
        $requete = "SELECT * FROM abonnements;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute();
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>
