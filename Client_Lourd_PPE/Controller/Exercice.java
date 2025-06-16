package controleur;

public class Exercice {
	private int idexo; 
	private String nom, dateExo; 
	private int tempsExo; 
	private String difficulteExo; 
	private int idclub;
	
	public Exercice(int idexo, String nom, String dateExo, int tempsExo, String difficulteExo, int idclub) {
		super();
		this.idexo = idexo;
		this.nom = nom;
		this.dateExo = dateExo;
		this.tempsExo = tempsExo;
		this.difficulteExo = difficulteExo;
		this.idclub = idclub;
	}
	public Exercice(String nom, String dateExo, int tempsExo, String difficulteExo, int idclub) {
		super();
		this.idexo = 0;
		this.nom = nom;
		this.dateExo = dateExo;
		this.tempsExo = tempsExo;
		this.difficulteExo = difficulteExo;
		this.idclub = idclub;
	}
	public int getIdexo() {
		return idexo;
	}
	public void setIdexo(int idexo) {
		this.idexo = idexo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDateExo() {
		return dateExo;
	}
	public void setDateExo(String dateExo) {
		this.dateExo = dateExo;
	}
	public int getTempsExo() {
		return tempsExo;
	}
	public void setTempsExo(int tempsExo) {
		this.tempsExo = tempsExo;
	}
	public String getDifficulteExo() {
		return difficulteExo;
	}
	public void setDifficulteExo(String difficulteExo) {
		this.difficulteExo = difficulteExo;
	}
	public int getIdclub() {
		return idclub;
	}
	public void setIdclub(int idclub) {
		this.idclub = idclub;
	}
	
	
	
	
}
