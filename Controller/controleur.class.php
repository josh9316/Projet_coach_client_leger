<?php
require_once ("modèle/modele.class.php");
class Controleur {
    private $unModele;

    public function __construct() {
        $this->unModele = new Modele();
    }
   /****************** Gestion des CLUBS ***********************/
public function selectAllClubs() {
    return $this->unModele->selectAllClubs();
}
public function insertClubs($tab) {
    // Contrôler les données du Club avant insertion.
    $this->unModele->insertClubs($tab);
}
public function selectLikeClubs($filtre) {
    return $this->unModele->selectLikeClubs($filtre);
}
public function deleteClub($idclub) {
    $this->unModele->deleteClub($idclub);
}
public function selectWhereClub($idclub) {
    return $this->unModele->selectWhereClub($idclub);
}
public function updateClub($idclub) {
    $this->unModele->updateClub($idclub);
}


   /****************** Gestion des Coachs ***********************/
   public function selectAllCoachs() {
    return $this->unModele->selectAllCoachs();
}
public function insertCoach($tab) {
    // Contrôler les données du Coach avant insertion.
    $this->unModele->insertCoach($tab);
}
public function selectLikeCoachs($filtre) {
    return $this->unModele->selectLikeCoachs($filtre);
}
public function deleteCoach($idCoach) {
    $this->unModele->deleteCoach($idCoach);
}
public function selectWhereCoach($idCoach) {
    return $this->unModele->selectWhereCoach($idCoach);
}
public function updateCoach($tab) {
    $this->unModele->updateCoach($tab);
}

/****************** Gestion des Exercice ***********************/
public function selectAllExercices() {
    return $this->unModele->selectAllExercices();
}

public function insertExercice($tab) {
    // Contrôler les données du Exercice avant insertion.
    $this->unModele->insertExercice($tab);
}

public function selectLikeExercices($filtre) {
    return $this->unModele->selectLikeExercices($filtre);
}

public function deleteExercice($idexercice) {
    $this->unModele->deleteExercice($idexercice);
}

public function selectWhereExercice($idexercice) {
    return $this->unModele->selectWhereExercice($idexercice);
}

public function updateExercice($tab) {
    $this->unModele->updateExercice($tab);
}

/****************** Gestions des RDV ***********************/

public function selectAllRDVs() {
    return $this->unModele->selectAllRDVs();
}

public function insertRDV($tab) {
    // Contrôler les données du RDV avant insertion.
    $this->unModele->insertRDV($tab);
}

public function selectLikeRDVs($filtre) {
    return $this->unModele->selectLikeRDVs($filtre);
}

public function deleteRDV($idrendezvous) {
    $this->unModele->deleteRDV($idrendezvous);
}

public function selectWhereRDV($idrendezvous) {
    return $this->unModele->selectWhereRDV($idrendezvous);
}

public function updateRDV($tab) {
    $this->unModele->updateRDV($tab);
}


/***********Gestion users*************/

public function verifConnexion ($email, $mdp){
    //Controle de donnée
    $tab = array("email"=> $email,"mdp"=> $mdp);

    //sha1 du mdp
    $mdp = sha1($mdp);
    
    if($this->verifDonnees ($tab)){
        //retourner le user resultat
        return $this->unModele->verifConnexion($email, $mdp);
    }else{
        return false;
    }   
}
public function verifDonnees ($tab){
    $verif = true;
    foreach ($tab as $cle => $valeur) {
        if ($valeur == "" || $valeur == null){
            $verif = false;
            break;
        }
    }
    return $verif;
    
}
}

?>