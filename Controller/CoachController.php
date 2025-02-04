<?php
require_once(__DIR__ . "/../Models/Database.php");
require_once(__DIR__ . "/../Models/Coachs.php");

class CoachController {
    private $coachsModel;

    public function __construct() {
        $this->coachsModel = new Coachs();
    }

    public function afficherCoachs() {
        return $this->coachsModel->selectAllCoachs();
    }

    public function ajouterCoach() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Valider'])) {
            if (!empty($_POST['nom']) && !empty($_POST['prenom']) && !empty($_POST['email'])) {
                $this->coachsModel->insertCoach($_POST);
                echo "<br>Insertion réussie du Coach !<br>";
            } else {
                echo "<br>Veuillez remplir tous les champs.";
            }
        }
    }

    public function modifierCoach() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Modifier'])) {
            if (!empty($_POST['nom']) && !empty($_POST['prenom']) && !empty($_POST['email'])) {
                $this->coachsModel->updateCoach($_POST);
                header("Location: ../index.php?page=3");
                exit();
            } else {
                echo "<br>Veuillez remplir tous les champs.";
            }
        }
    }

    public function supprimerCoach() {
        if (isset($_GET['action']) && $_GET['action'] === "sup" && isset($_GET['idcoachs'])) {
            $this->coachsModel->deleteCoach($_GET['idcoachs']);
            header("Location: ../index.php?page=3");
            exit();
        }
    }

    public function recupererCoach() {
        if (isset($_GET['action']) && $_GET['action'] === "edit" && isset($_GET['idcoachs'])) {
            return $this->coachsModel->selectWhereCoach($_GET['idcoach']);
        }
        return null;
    }

    public function filtrerCoachs() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Filtrer'])) {
            return $this->coachsModel->selectLikeCoachs($_POST['filtre']);
        }
        return $this->coachsModel->selectAllCoachs();
    }
}

$controller = new CoachController();
$leCoach = $controller->recupererCoach();
$lesCoachs = $controller->filtrerCoachs();
$controller->ajouterCoach();
$controller->modifierCoach();
$controller->supprimerCoach();
?>
