package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Coach;
import controleur.Exercice;
import controleur.Listing;
import controleur.Club;

public class Modele {
	private static Connexion uneConnexion = new Connexion("localhost", "clourd_bask", "root", "");

	/************************ GESTION DES Coachs **********************/
	public static void insertCoach(Coach unCoach) {
		String requete = "INSERT INTO coach VALUES (null, '" + unCoach.getNom()
				+ "', '" + unCoach.getPrenom() + "', '" + unCoach.getQualification()
				+ "', '" + unCoach.getEmail() + "', '" + unCoach.getMdp()
				+ "', '" + unCoach.getTel() + "');";
		executerRequete(requete);
	}

	public static ArrayList<Coach> selectAllCoachs() {
		ArrayList<Coach> lesCoachs = new ArrayList<>();
		String requete = "SELECT * FROM coach;";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet rs = unStat.executeQuery(requete);
			while (rs.next()) {
				Coach coach = new Coach(
					rs.getInt("idcoach"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("qualification"), rs.getString("email"),
					rs.getString("mdp"), rs.getString("tel")
				);
				lesCoachs.add(coach);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return lesCoachs;
	}

	public static void deleteCoach(int idCoach) {
		String requete = "DELETE FROM coach WHERE idcoach = " + idCoach + ";";
		executerRequete(requete);
	}

	public static void updateCoach(Coach coach) {
		String requete = "UPDATE coach SET nom = '" + coach.getNom()
				+ "', prenom = '" + coach.getPrenom()
				+ "', qualification = '" + coach.getQualification()
				+ "', email = '" + coach.getEmail()
				+ "', mdp = '" + coach.getMdp()
				+ "', tel = '" + coach.getTel()
				+ "' WHERE idcoach = " + coach.getIdCoach() + ";";
		executerRequete(requete);
	}

	public static Coach selectWhereCoach(int idCoach) {
		Coach coach = null;
		String requete = "SELECT * FROM coach WHERE idcoach = " + idCoach + ";";
		try {
			uneConnexion.seConnecter();
			Statement st = uneConnexion.getMaConnexion().createStatement();
			ResultSet rs = st.executeQuery(requete);
			if (rs.next()) {
				coach = new Coach(
					rs.getInt("idcoach"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("qualification"), rs.getString("email"),
					rs.getString("mdp"), rs.getString("tel")
				);
			}
			st.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return coach;
	}
	
	public static Coach selectWhereCoach(String email, String mdp) {
		Coach coach = null;
		String requete = "SELECT * FROM coach WHERE email ='"+email + "' and mdp='"+mdp+"';";
		try {
			uneConnexion.seConnecter();
			Statement st = uneConnexion.getMaConnexion().createStatement();
			ResultSet rs = st.executeQuery(requete);
			if (rs.next()) {
				coach = new Coach(
					rs.getInt("idcoach"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("qualification"), rs.getString("email"),
					rs.getString("mdp"), rs.getString("tel")
				);
			}
			st.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return coach;
	}

	/************************ GESTION DES Clubs **********************/
	public static void insertClub(Club club) {
		String requete = "INSERT INTO club VALUES (null, '" + club.getNom()
				+ "', '"  + club.getAdresse()
				+ "', '" + club.getEmail() + "', '" + club.getTel() + "');";
		executerRequete(requete);
	}

	public static ArrayList<Club> selectLikeClubs(String filtre) {
		return null;
	}
	public static ArrayList<Club> selectAllClubs() {
		ArrayList<Club> clubs = new ArrayList<>();
		String requete = "SELECT * FROM club;";
		try {
			uneConnexion.seConnecter();
			Statement st = uneConnexion.getMaConnexion().createStatement();
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				Club club = new Club(
					rs.getInt("idclub"), rs.getString("nom"), 
					rs.getString("adresse"), rs.getString("email"), rs.getString("tel")
				);
				clubs.add(club);
			}
			st.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return clubs;
	}

	public static void deleteClub(int idClub) {
		String requete = "DELETE FROM club WHERE idclub = " + idClub + ";";
		executerRequete(requete);
	}

	public static void updateClub(Club club) {
		String requete = "UPDATE club SET nom = '" + club.getNom()
				 
				+ "', adresse = '" + club.getAdresse()
				+ "', email = '" + club.getEmail()
				+ "', tel = '" + club.getTel()
				+ "' WHERE idclub = " + club.getIdClub() + ";";
		executerRequete(requete);
	}

	public static Club selectWhereClub(int idClub) {
		Club club = null;
		String requete = "SELECT * FROM club WHERE idclub = " + idClub + ";";
		try {
			uneConnexion.seConnecter();
			Statement st = uneConnexion.getMaConnexion().createStatement();
			ResultSet rs = st.executeQuery(requete);
			if (rs.next()) {
				club = new Club(
					rs.getInt("idclub"), rs.getString("nom"), 
					rs.getString("adresse"), rs.getString("email"), rs.getString("tel")
				);
			}
			st.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return club;
	}

	/************************ GESTION DES EXERCICES **********************/
	public static void executerRequete(String requete) {
		try {
			uneConnexion.seConnecter();
			Statement st = uneConnexion.getMaConnexion().createStatement();
			st.execute(requete);
			st.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	public static void insertExercice(Exercice unExercice) {
	    String requete = "INSERT INTO exercice VALUES (null, '" + unExercice.getNom()
	            + "', '" + unExercice.getDateExo()
	            + "', " + unExercice.getTempsExo() 
	            + ", '" + unExercice.getDifficulteExo() 
	            + "', " + ");";
	    executerRequete(requete);
	}

	
	
	public static ArrayList<Exercice> selectAllExercices() {
		ArrayList<Exercice> exercices = new ArrayList<>();
		String requete = "SELECT * FROM exercice;";
		try {
			uneConnexion.seConnecter();
			Statement st = uneConnexion.getMaConnexion().createStatement();
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				Exercice exercice = new Exercice(
					rs.getInt("idexo"), rs.getString("nom"), 
					rs.getString("dateExo"), rs.getInt("tempsExo"), rs.getString("difficulteExo"), rs.getInt("idclub")
				);
				exercices.add(exercice);
			}
			st.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return exercices;
	}

	public static void deleteExercice(int idexo) {
		String requete = "DELETE FROM Exercice WHERE idclub = " + idexo + ";";
		executerRequete(requete);
		
	}

	public static void updateExercice(Exercice unExercice) {
		String requete = new String();
		executerRequete(requete);
		
	}

	public static Exercice selectWhereExercice(int idexo) {
	    Exercice exercice = null;
	    String requete = "SELECT * FROM exercice WHERE idexo = " + idexo + ";";
	    try {
	        uneConnexion.seConnecter();
	        Statement st = uneConnexion.getMaConnexion().createStatement();
	        ResultSet rs = st.executeQuery(requete);
	        if (rs.next()) {
	            exercice = new Exercice(
	                rs.getInt("idexo"), 
	                rs.getString("nom"), 
	                rs.getString("dateExo"), 
	                rs.getInt("tempsExo"), 
	                rs.getString("difficulteExo"), 
	                rs.getInt("idclub")
	            );
	        }
	        st.close();
	        uneConnexion.seDeConnecter();
	    } catch (SQLException e) {
	        System.out.println("Erreur : " + e.getMessage());
	    }
	    return exercice;
	}

	public static ArrayList<Exercice> selectLikeExercices(String filtre) {
	    ArrayList<Exercice> exercices = new ArrayList<>();
	    String requete = "SELECT * FROM exercice WHERE nom LIKE '%" + filtre 
	                   + "%' OR dateExo LIKE '%" + filtre 
	                   + "%' OR difficulteExo LIKE '%" + filtre + "%';";
	    try {
	        uneConnexion.seConnecter();
	        Statement st = uneConnexion.getMaConnexion().createStatement();
	        ResultSet rs = st.executeQuery(requete);
	        while (rs.next()) {
	            Exercice exercice = new Exercice(
	                rs.getInt("idexo"), 
	                rs.getString("nom"), 
	                rs.getString("dateExo"), 
	                rs.getInt("tempsExo"), 
	                rs.getString("difficulteExo"), 
	                rs.getInt("idclub")
	            );
	            exercices.add(exercice);
	        }
	        st.close();
	        uneConnexion.seDeConnecter();
	    } catch (SQLException e) {
	        System.out.println("Erreur : " + e.getMessage());
	    }
	    return exercices;
	}

	public static ArrayList<Listing> selectAllListings2024() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<Coach> selectLikeCoachs(String filtre) {
		// TODO Auto-generated method stub
		return null;
	}
}
