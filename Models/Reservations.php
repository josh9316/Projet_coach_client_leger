<?php
require_once("Database.php");

class Reservation {
    private $unPdo;

    public function __construct() {
        $db = new Database();
        $this->unPdo = $db->getConnection();
    }

    public function selectAllReservations() {
        $requete = "SELECT * FROM Reservation;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute();
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }

    public function selectWhereReservation($idReservation) {
        $requete = "SELECT * FROM Reservation WHERE idReservation = :idReservation;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idReservation" => $idReservation]);
        return $exec->fetch(PDO::FETCH_ASSOC);
    }

    public function insertReservation($tab) {
        $requete = "INSERT INTO Reservation (Utilisateur_ID, Coach_ID, Date, Statut) 
                    VALUES (:Utilisateur_ID, :Coach_ID, :Date, :Statut);";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([
            ":Utilisateur_ID" => $tab['Utilisateur_ID'],
            ":Coach_ID" => $tab['Coach_ID'],
            ":Date" => $tab['Date'],
            ":Statut" => $tab['Statut']
        ]);
    }

    public function updateReservation($tab) {
        $requete = "UPDATE Reservation 
                    SET Utilisateur_ID = :Utilisateur_ID, 
                        Coach_ID = :Coach_ID, 
                        Date = :Date, 
                        Statut = :Statut 
                    WHERE idReservation = :idReservation;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([
            ":Utilisateur_ID" => $tab['Utilisateur_ID'],
            ":Coach_ID" => $tab['Coach_ID'],
            ":Date" => $tab['Date'],
            ":Statut" => $tab['Statut'],
            ":idReservation" => $tab['idReservation']
        ]);
    }

    public function deleteReservation($idReservation) {
        $requete = "DELETE FROM Reservation WHERE idReservation = :idReservation;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":idReservation" => $idReservation]);
    }

    public function selectLikeReservations($filtre) {
        $requete = "SELECT * FROM Reservation 
                    WHERE Date LIKE :filtre 
                    OR Statut LIKE :filtre 
                    OR Utilisateur_ID LIKE :filtre 
                    OR Coach_ID LIKE :filtre;";
        $exec = $this->unPdo->prepare($requete);
        $exec->execute([":filtre" => "%" . $filtre . "%"]);
        return $exec->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>
