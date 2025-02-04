<?php
require_once(__DIR__ . "/../Models/Clubs.php");

class ClubsController {
    private $clubModel;

    public function __construct() {
        $this->clubModel = new Clubs();
    }

    public function afficherClubs() {
        return $this->clubModel->selectAllClubs();
    }

    public function ajouterClub() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Valider'])) {
            if (!empty($_POST['nom']) && !empty($_POST['adresse'])) {
                $this->clubModel->insertClubs($_POST);
                $_SESSION['successMessage'] = "Insertion réussie du Club !";
                header("Location: index.php?page=2");
                exit();
            } else {
                $_SESSION['errorMessage'] = "Veuillez remplir tous les champs.";
            }
        }
    }
    

    public function modifierClub() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Modifier'])) {
            if (!empty($_POST['nom']) && !empty($_POST['adresse'])) {
                $this->clubModel->updateClub($_POST);
                header("Location: ../index.php?page=2");
                exit();
            } else {
                echo "<br>Veuillez remplir tous les champs.";
            }
        }
    }

    public function supprimerClub() {
        if (isset($_GET['action']) && $_GET['action'] === "sup" && isset($_GET['idclub'])) {
            $this->clubModel->deleteClub($_GET['idclub']);
            header("Location: ../index.php?page=2");
            exit();
        }
    }

    public function recupererClub() {
        if (isset($_GET['action']) && $_GET['action'] === "edit" && isset($_GET['idclub'])) {
            return $this->clubModel->selectWhereClub($_GET['idclub']);
        }
        return null;
    }

    public function filtrerClubs() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Filtrer'])) {
            return $this->clubModel->selectLikeClubs($_POST['filtre']);
        }
        return $this->clubModel->selectAllClubs();
    }
}

$controller = new ClubsController();
$leClub = $controller->recupererClub();
$lesClubs = $controller->filtrerClubs();
$controller->ajouterClub();
$controller->modifierClub();
$controller->supprimerClub();
?>
