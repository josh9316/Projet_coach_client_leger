<?php
require_once("Database.php");

class Utilisateur {
    private $pdo;

    public function __construct() {
        $db = new Database();
        $this->pdo = $db->getConnection();
    }

    public function login($email, $mdp) {
        $query = $this->pdo->prepare("SELECT * FROM user WHERE email = :email");
        $query->execute(['email' => $email]);

        $user = $query->fetch(PDO::FETCH_ASSOC);

        if (!$user) {  
            return false;
        }

        if ($user['mdp'] === $mdp) {
            return $user; 
        }

        return false; 
    }
}
?>
