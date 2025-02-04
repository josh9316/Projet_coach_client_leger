<?php
require_once(__DIR__ . "/../Models/Reservations.php");

class RdvController {
    private $rdvModel;

    public function __construct() {
        $this->rdvModel = new Reservation();
    }

    public function afficherRDVs() {
        return $this->rdvModel->selectAllReservations();
    }

    public function ajouterRDV() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Valider'])) {
            if (!empty($_POST['dateRendezVous']) && !empty($_POST['motif']) && !empty($_POST['idclub']) && !empty($_POST['idcoach']) && !empty($_POST['idexercice'])) {
                $this->rdvModel->insertRDV($_POST);
                echo "<br>Insertion réussie du RDV !<br>";
            } else {
                echo "<br>Veuillez remplir tous les champs.";
            }
        }
    }

    public function modifierRDV() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Modifier'])) {
            if (!empty($_POST['dateRendezVous']) && !empty($_POST['motif']) && !empty($_POST['idclub']) && !empty($_POST['idcoach']) && !empty($_POST['idexercice']) && !empty($_POST['idrendezvous'])) {
                $this->rdvModel->updateRDV($_POST);
                header("Location: ../index.php?page=5");
                exit();
            } else {
                echo "<br>Veuillez remplir tous les champs.";
            }
        }
    }

    public function supprimerRDV() {
        if (isset($_GET['action']) && $_GET['action'] === "sup" && isset($_GET['idrendezvous'])) {
            $this->rdvModel->deleteRDV($_GET['idrendezvous']);
            header("Location: ../index.php?page=5");
            exit();
        }
    }

    public function recupererRDV() {
        if (isset($_GET['action']) && $_GET['action'] === "edit" && isset($_GET['idrendezvous'])) {
            return $this->rdvModel->selectWhereRDV($_GET['idrendezvous']);
        }
        return null;
    }

    public function filtrerRDVs() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Filtrer'])) {
            return $this->rdvModel->selectLikeRDVs($_POST['filtre']);
        }
        return $this->rdvModel->selectAllReservations();
    }

}

$controller = new RdvController();
$leRDV = $controller->recupererRDV();
$lesRDVs = $controller->filtrerRDVs();
$controller->ajouterRDV();
$controller->modifierRDV();
$controller->supprimerRDV();

?>
