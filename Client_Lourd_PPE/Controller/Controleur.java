package controleur;

import java.util.ArrayList;
import modele.Modele;

public class Controleur {

	/******************* Vérification des champs *******************/
	public static boolean verifDonnees(ArrayList<String> lesChamps) {
		for (String champ : lesChamps) {
			if (champ.isEmpty()) return false;
		}
		return true;
	}

	/******************* Gestion des Coachs *******************/
	public static void insertCoach(Coach unCoach) {
		Modele.insertCoach(unCoach);
	}

	public static ArrayList<Coach> selectAllCoachs() {
		return Modele.selectAllCoachs();
	}

	public static void deleteCoach(int idCoach) {
		Modele.deleteCoach(idCoach);
	}

	public static void updateCoach(Coach unCoach) {
		Modele.updateCoach(unCoach);
	}

	public static ArrayList<Coach> selectLikeCoachs(String filtre) {
		return Modele.selectLikeCoachs(filtre);
	}

	public static Coach selectWhereCoach(int idCoach) {
		return Modele.selectWhereCoach(idCoach);
	}

	public static Coach selectWhereCoach(String email, String mdp) {
		return Modele.selectWhereCoach(email, mdp);
	}

	/******************* Gestion des Clubs *******************/
	public static void insertClub(Club unClub) {
		Modele.insertClub(unClub);
	}

	public static ArrayList<Club> selectAllClubs() {
		return Modele.selectAllClubs();
	}

	public static void deleteClub(int idClub) {
		// appelle la procédure stockée deleteclub
		Modele.deleteClub(idClub);
	}

	public static void updateClub(Club unClub) {
		Modele.updateClub(unClub);
	}

	public static ArrayList<Club> selectLikeClubs(String filtre) {
		return Modele.selectLikeClubs(filtre);
	}

	public static Club selectWhereClub(int idClub) {
		return Modele.selectWhereClub(idClub);
	}

	/*public static Club selectWhereClub(String email, String mdp) {
		return Modele.selectWhereClub(email, mdp);
	}*/

	/******************* Gestion des Exercices *******************/
	public static void insertExercice(Exercice unExercice) {
		Modele.insertExercice(unExercice);
	}

	public static ArrayList<Exercice> selectAllExercices() {
		return Modele.selectAllExercices();
	}

	public static void deleteExercice(int idexo) {
		Modele.deleteExercice(idexo);
	}

	public static void updateExercice(Exercice unExercice) {
		Modele.updateExercice(unExercice);
	}

	public static Exercice selectWhereExercice(int idexo) {
		return Modele.selectWhereExercice(idexo);
	}
	
	public static ArrayList<Exercice> selectLikeExercices(String filtre) {
		return Modele.selectLikeExercices(filtre);
	}

	
	/******************* Gestion de la Vue Listing *******************/
	public static ArrayList<Listing> selectAllListings2024() {
		return Modele.selectAllListings2024();
	}

	public static Club selectWhereClub(String email, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}
}
