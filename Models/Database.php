<?php
class Database {
    private static $instance = null;
    private $pdo;

    // Définition des constantes de connexion
    private const DB_HOST = "localhost";
    private const DB_NAME = "coaching_basket";
    private const DB_USER = "root";
    private const DB_PASS = "";

    public function __construct() {
        try {
            $dsn = "mysql:host=" . self::DB_HOST . ";dbname=" . self::DB_NAME . ";charset=utf8";
            $this->pdo = new PDO($dsn, self::DB_USER, self::DB_PASS, [
                PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
                PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
            ]);
        } catch (PDOException $exp) {
            // Ne pas afficher les erreurs de connexion en production
            die("Erreur de connexion à la base de données.");
        }
    }

    // Singleton pour éviter plusieurs connexions
    public static function getInstance() {
        if (self::$instance === null) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function getConnection() {
        return $this->pdo;
    }
}
?>
