<?php
session_start();
require_once(__DIR__ . "/../Models/Database.php");
require_once(__DIR__ . "/../Models/Utilisateur.php");

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

                if ($user) {
                    $_SESSION['user_id'] = $user['iduser'];  
                    $_SESSION['email'] = $user['email'];
                    $_SESSION['nom'] = $user['nom'];

                    header("Location: ../index.php"); 
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
<div class="user-widget">
  <?php if( isset($_SESSION['user_id']) && $_SESSION['user_id'] !== null ) : ?>
    <a href="/logout.php">Se déconnecter</a>
  <?php else : ?>
    <a href="/login.php">Se connecter</a>
  <?php endif; ?>
</div>

$controller = new ConnexionController();
$error = $controller->login();



?>
