package controleur;

public class Coach {
	private int idCoach;
	private String nom, prenom, qualification, email, mdp, tel;

	public Coach(int idCoach, String nom, String prenom, String qualification, String email, String mdp, String tel) {
		this.idCoach = idCoach;
		this.nom = nom;
		this.prenom = prenom;
		this.qualification = qualification;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	}

	public Coach(String nom, String prenom, String qualification, String email, String mdp, String tel) {
		this.idCoach = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.qualification = qualification;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	}

	public int getIdCoach() {
		return idCoach;
	}

	public void setIdCoach(int idCoach) {
		this.idCoach = idCoach;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
