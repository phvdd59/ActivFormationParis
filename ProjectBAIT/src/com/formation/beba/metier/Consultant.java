package com.formation.beba.metier;

public class Consultant {
	private final String identifiant = new String();
	private String prenom = new String();
	private String nom = new String();
	private String mdp = new String();
	
	private String situation = new String();
	
	private String fonction = new String();
	private String position = new String();
	private String salaire = new String();
	private boolean ticket=false ;
	private boolean cadre=false;
	private String coeff  = new String();
	private String adresse = new String();
	private String cP = new String();
	private String ville = new String();
	private String tel = new String();
	private String email= new String();
	
	
	
	public Consultant(String identifiant, String mdp) {

		this.identifiant = identifiant;
		this.prenom = "";
		this.nom = "";
		this.mdp = mdp;
		
		this.fonction="";
		this.position="";
		this.salaire="";
		this.ticket=false;
		this.cadre=false;
		this.coeff="";
		this.adresse="";
		this.cP="";
		this.ville="";
		this.tel="";
		this.email="";
		
	}



	public String getIdentifiant() {
		return identifiant;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getSituation() {
		return situation;
	}



	public void setSituation(String situation) {
		this.situation = situation;
	}



	public String getFonction() {
		return fonction;
	}



	public void setFonction(String fonction) {
		this.fonction = fonction;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getSalaire() {
		return salaire;
	}



	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}



	public boolean isTicket() {
		return ticket;
	}



	public void setTicket(boolean ticket) {
		this.ticket = ticket;
	}



	public boolean isCadre() {
		return cadre;
	}



	public void setCadre(boolean cadre) {
		this.cadre = cadre;
	}



	public String getCoeff() {
		return coeff;
	}



	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getcP() {
		return cP;
	}



	public void setcP(String cP) {
		this.cP = cP;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
