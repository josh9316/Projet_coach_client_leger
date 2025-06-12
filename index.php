<?php
require("Controller/ConnexionController.php");
//require_once "Controller/StatController.php"; // Ajout du contrôleur des statistiques
require_once ("Models/Database.php");


/* Vérification des fichiers
if (!file_exists('controllers/StatController.php')) {
    die("Erreur : Le fichier StatController.php est introuvable.");
}
*
//require_once "controllers/StatController.php";
*/
require_once "Models/Database.php";

$page = isset($_GET['page']) ? $_GET['page'] : 'home';

switch ($page) {
    case 'stats':
        $statController = new StatController($db);
        $statController->showStats();
        break;
    default:
       // echo "<h2>Bienvenue sur le site</h2>";
        break;
}
?>




