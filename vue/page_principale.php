<?php 
    session_start();
    if(empty($_SESSION)){
        header('Location: ../index.php');
    }
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOOPS Coaching Basket</title>
    <style>
        /* Styles généraux */
        body {
            font-family: 'Montserrat', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        /* Barre de navigation */
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #ffffff;
            padding: 15px 30px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .site-title {
            font-size: 1.5em;
            font-weight: bold;
            color: #333;
        }

        .nav-links {
            display: flex;
            gap: 20px;
        }

        .nav-links a {
            text-decoration: none;
            color: #333;
            font-size: 1.2em;
            font-weight: bold;
            padding: 10px 15px;
            transition: background 0.3s;
            border-radius: 5px;
        }

        .nav-links a:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }

        /* Conteneur principal */
        section {
            padding: 20px;
            max-width: 1200px;
            margin: auto;
            background-color: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        /* Pied de page */
        footer {
            background-color: #343a40;
            color: white;
            padding: 15px 0;
            margin-top: 40px;
            font-size: 1.1em;
        }
    </style>
</head>
<body>
    <nav>
        <div class="site-title">Cabinet BASKET_MVC</div>
        <div class="nav-links">
            <a href="page_principale.php?page=1">Home</a>
            <a href="page_principale.php?page=2">Club</a>
            <a href="page_principale.php?page=3">Coach</a>
            <a href="page_principale.php?page=4">Exercice</a>
            <a href="page_principale.php?page=5">Contact</a>
            <a href="deconnexion.php">Se déconnecter</a>
        </div>
    </nav>
    
    <section>
        <?php
        $page = isset($_GET['page']) ? $_GET['page'] : 1;
        switch ($page) {
            case 1:
                require_once("../CSS/Home.html");
                break;
            case 2:
                require_once("../Controller/ClubsController.php");
                require_once("../vue/vue_select_club.php");
                require_once("../vue/vue_insert_club.php");
                break;
            case 3:
                require_once("../Controller/CoachController.php");
                require_once("../vue/vue_select_coachs.php");
                require_once("../vue/vue_insert_coach.php");
                break;
            case 4:
                require_once("../Controller/ExerciceController.php");
                require_once("../vue/vue_select_exercices.php");
                break;
            case 5:
                require_once("../vue/page_contact.php");
                break;
            default:
                echo "<p>Page non trouvée</p>";
                break;
        }
        ?>
    </section>

    <footer>
        <p>&copy; 2025 - Tous droits réservés</p>
    </footer>
</body>
</html>