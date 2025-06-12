<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "coaching_basket";

try {
    $bdd = new PDO("mysql:host=$servername;dbname=$database", $username, $password);
    $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    // echo "Connexion réussie";
} catch (PDOException $e) {
    echo "Erreur de connexion : " . $e->getMessage();
    exit;
}

// Vérifie si le formulaire a été soumis
if (isset($_POST['ok'])) {
    // Récupération des données du formulaire
    $nom = htmlspecialchars(trim($_POST['nom']));
    $prenom = htmlspecialchars(trim($_POST['prenom']));
    $email = htmlspecialchars(trim($_POST['email']));
    $motdepasse = $_POST['motdepasse'];

    // Validation des champs
    if (empty($nom) || empty($prenom) || empty($email) || empty($motdepasse)) {
        echo "Tous les champs sont obligatoires!";
        exit;
    }

    // Vérifier si l'email est déjà utilisé
    $requete = $bdd->prepare("SELECT * FROM user WHERE email = :email");
    $requete->execute(array('email' => $email));
    if ($requete->rowCount() > 0) {
        echo "Cet email est déjà utilisé!";
        exit;
    }

    // Sécurisation du mot de passe
    // $passwordHash = password_hash($motdepasse, PASSWORD_BCRYPT);

    // Préparation de la requête d'insertion
    $requete = $bdd->prepare("INSERT INTO user (nom, prenom, email, password) VALUES (:nom, :prenom, :email, :password)");
    
    // Exécution de la requête avec les données
    $requete->execute(array(
        'nom' => $nom,
        'prenom' => $prenom,
        'email' => $email,
        'password' => $motdepasse // Utilisez password_hash($motdepasse, PASSWORD_BCRYPT) pour sécuriser le mot de passe
    ));

    echo "Inscription réussie!";
    
    // Rediriger vers la page de connexion après 2 secondes
    header("refresh:2;url=../index.php");
    exit;
}
?>
