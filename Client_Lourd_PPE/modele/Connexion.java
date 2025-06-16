package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private String serveur, bdd, user, mdp;
	private Connection maConnexion;

	// Constructeur : initialise les paramètres de connexion
	public Connexion(String serveur, String bdd, String user, String mdp) {
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
		this.maConnexion = null;
	}

	// Charge le pilote JDBC pour MySQL
	private void chargerPilote() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur : pilote JDBC introuvable.");
		}
	}

	// Établit la connexion à la base de données
	public void seConnecter() {
		this.chargerPilote();
		String url = "jdbc:mysql://" + this.serveur + "/" + this.bdd + "?useSSL=false&serverTimezone=UTC";

		try {
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
			System.out.println("Connexion réussie à la base : " + this.bdd);
		} catch (SQLException e) {
			System.out.println("Échec de connexion à : " + url);
			e.printStackTrace();
		}
	}

	// Ferme la connexion à la base de données
	public void seDeConnecter() {
		try {
			if (this.maConnexion != null && !this.maConnexion.isClosed()) {
				this.maConnexion.close();
				System.out.println("Déconnexion réussie.");
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la déconnexion.");
			e.printStackTrace();
		}
	}

	// Retourne l'objet Connection pour les opérations SQL
	public Connection getMaConnexion() {
		return this.maConnexion;
	}
}
