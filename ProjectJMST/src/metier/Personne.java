package metier;

public class Personne {

	private String	nom;
	private String	prenom;
	private String	login;
	private String	motDePasse;
	private String	mail;
	private boolean	admin;

	public Personne(String nom, String login, String motDePasse, boolean admin, String mail) {
		this.nom = nom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
		this.mail = mail;
		this.prenom = "";
	}

	public Personne(String prenom, String login, String mail) {
		this.login = login;
		this.prenom = prenom;
		this.mail = mail;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
