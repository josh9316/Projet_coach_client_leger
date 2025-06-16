package controleur;

public class Club {
	private int idClub;
	private String nom,adresse, email, tel;

	public Club(int idClub, String nom,  String adresse, String email, String tel) {
		this.idClub = idClub;
		this.nom = nom;
		 
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public Club(String nom , String adresse, String email, String tel) {
		this.idClub = 0;
		this.nom = nom;
		 
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	 

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
