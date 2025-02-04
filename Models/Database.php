<?php
class Database {
    private $pdo;

    public function __construct() {
        try {
            $this->pdo = new PDO("mysql:host=localhost;dbname=coaching_basket", "root", "");
            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $exp) {
            die("Erreur de connexion : " . $exp->getMessage());
        }
    }

    public function getConnection() {
        return $this->pdo;
    }
}
?>