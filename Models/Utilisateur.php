<?php
require_once("Database.php");

class Utilisateur {
    private $pdo;

    public function __construct() {
        $db = new Database();
        $this->pdo = $db->getConnection();
    }

    // Méthode de connexion
    public function login($email, $mdp) {
        // Utilisation de la table "users" pour être cohérent avec le reste du code
        $query = $this->pdo->prepare("SELECT * FROM user WHERE email = :email");
        $query->execute([':email' => $email]);
        $user = $query->fetch(PDO::FETCH_ASSOC);

        if (!$user) {  
            return false;
        }

        // Vérification du mot de passe haché
        if ($mdp ==$user['password'] ) {//(password_verify($mdp, $user['password'])) {
            return $user; 
        }

        return false; 
    }

    // Méthode d'inscription d'un utilisateur
    public function registerUser($nom, $prenom, $email, $password) {
        // Vérifie si l'email existe déjà
        if ($this->emailExists($email)) {
            return false;
        }

        $hashed_password = password_hash($password, PASSWORD_DEFAULT);
        $stmt = $this->pdo->prepare("INSERT INTO users (nom, prenom, email, password) VALUES (:nom, :prenom, :email, :password)");
        return $stmt->execute([
            ':nom'      => $nom,
            ':prenom'   => $prenom,
            ':email'    => $email,
            ':password' => $hashed_password
        ]);
    }

    // Méthode pour vérifier si l'email existe déjà en base
    public function emailExists($email) {
        $stmt = $this->pdo->prepare("SELECT * FROM users WHERE email = :email");
        $stmt->execute([':email' => $email]);
        return $stmt->rowCount() > 0;
    }
}
?>
