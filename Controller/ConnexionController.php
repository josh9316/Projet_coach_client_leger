<?php
session_start();
require_once(__DIR__ . "/../Models/Database.php");
require_once(__DIR__ . "/../Models/Utilisateur.php");
include(__DIR__."/../vue/login.php");

class ConnexionController {
    private $utilisateurModel;

    public function __construct() {
        $this->utilisateurModel = new Utilisateur();
    }

    public function login() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Connexion'])) {
            $email = trim($_POST['email']);
            $mdp = trim($_POST['mdp']);

            if (!empty($email) && !empty($mdp)) {
                $user = $this->utilisateurModel->login($email, $mdp);
                //var_dump($user);
                if ($user) {
                    $_SESSION['user_id'] = $user['iduser'];  
                    $_SESSION['email'] = $user['email'];
                    $_SESSION['nom'] = $user['nom'];

                    header("Location: /Projet_coach/vue/page_principale.php");
                    exit();
                } else {
                    return "Email ou mot de passe incorrect.";
                }
            } else {
                return "Veuillez remplir tous les champs.";
            }
        }
        return null;
    }
}

$controller = new ConnexionController();
$error = $controller->login();
?>



