<?php
require_once(__DIR__ . "/../Models/Exercice.php");

class ExerciceController {
    private $exerciceModel;

    public function __construct() {
        $this->exerciceModel = new Exercice();
    }

    public function afficherExercices() {
        return $this->exerciceModel->selectAllExercices();
    }

    public function ajouterExercice() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Valider'])) {
            if (!empty($_POST['nom']) && !empty($_POST['description']) && !empty($_POST['duree'])) {
                $this->exerciceModel->insertExercice($_POST);
                $_SESSION['successMessage'] = "Exercice ajouté avec succès !";
                header("Location: index.php?page=4");
                exit();
            } else {
                $_SESSION['errorMessage'] = "Veuillez remplir tous les champs.";
            }
        }
    }

    public function modifierExercice() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Modifier'])) {
            if (!empty($_POST['nom']) && !empty($_POST['description']) && !empty($_POST['duree']) && !empty($_POST['idexercice'])) {
                $this->exerciceModel->updateExercice($_POST);
                $_SESSION['successMessage'] = "Exercice modifié avec succès !";
                header("Location: index.php?page=4");
                exit();
            } else {
                $_SESSION['errorMessage'] = "Veuillez remplir tous les champs.";
            }
        }
    }

    public function supprimerExercice() {
        if (isset($_GET['action']) && $_GET['action'] === "sup" && isset($_GET['idexercice'])) {
            $this->exerciceModel->deleteExercice($_GET['idexercice']);
            $_SESSION['successMessage'] = "Exercice supprimé avec succès !";
            header("Location: index.php?page=4");
            exit();
        }
    }

    public function recupererExercice() {
        if (isset($_GET['action']) && $_GET['action'] === "edit" && isset($_GET['idexercice'])) {
            return $this->exerciceModel->selectWhereExercice($_GET['idexercice']);
        }
        return null;
    }

    public function filtrerExercices() {
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Filtrer'])) {
            return $this->exerciceModel->selectLikeExercices($_POST['filtre']);
        }
        return $this->exerciceModel->selectAllExercices();
    }
}

// Instanciation du contrôleur
$controller = new ExerciceController();
$leExercice = $controller->recupererExercice();
$lesExercices = $controller->filtrerExercices();
$controller->ajouterExercice();
$controller->modifierExercice();
$controller->supprimerExercice();
?>
