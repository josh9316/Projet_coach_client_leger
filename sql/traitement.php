<?php
//*traitemnt.php traite les informations et à les intégrer dans la base de données
$username = "localhost";
$username= "root";
$password = "";
 
try{
    $bdd = new PDO("mysql:host=$servername;dbname=utilisateur", $username, $password);
    $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    //echo "connexion réussie";
}
 
 
 
 
if (isset($POST['ok'])){
    //extract($_POST); extrait les données du tableau $_POST pour les transformer en variables
   
    $nom = $_POST['nom'];
    $prenom = $_POST['prenom'];
    $mdp = $_POST['email'];
    $password = $_POST['password'];
    //var_dump($_POST);
//cette variable (ci-dessus) stock donc nos infos dans la BDD
 
//requête SQL Préparer
$requete = $bdd->prepare("INSERT INTO user VALUES (0, :pseudo, :nom, :prenom, MD5(:mdp), :email)");
$requete->execute(array(
    'pseudo' => $pseudo,
    'nom' => $nom,
    'prenom' => $prenom,
    'mdp' => $mdp,
    'email' => $email
    )
);
 $requete = $requete->fetch(PDO::FETCH_ASSOC);
 //permet de récupérer les données de la requête
 
 echo "Inscription réussie";
 
header("Location: login.php");
 
//requête SQL Préparer
 
}
 
?>