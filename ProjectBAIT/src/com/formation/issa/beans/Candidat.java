package com.formation.issa.beans;

public class Candidat {

	
	
	private String nom;
	private String prenom;
	private String identifiant;
	private String motDePasse; 
	private String email;	
	private String adresse;
	private String codePostal;//CP
	private String ville;
	private String tel; //telFixe et telPort
	//fax
	private String dateDeNaissance;
	private String lieu; //lieuNaissance	
	private String numeroDeSecuriteSociale;//numSecu
	private String nationalite;
	//private String position;
	private String position;
	private String coefficient; //coeff
	private String salaireSouhaite; //salaire
	private String fonctionOccupee;		
	
	
	

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNumeroDeSecuriteSociale() {
		return numeroDeSecuriteSociale;
	}

	public void setNumeroDeSecuriteSociale(String numeroDeSecuriteSociale) {
		this.numeroDeSecuriteSociale = numeroDeSecuriteSociale;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		ville = ville;
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

	public String getFonctionOccupee() {
		return fonctionOccupee;
	}

	public void setFonctionOccupee(String fonctionOccupee) {
		this.fonctionOccupee = fonctionOccupee;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}

	public String getSalaireSouhaite() {
		return salaireSouhaite;
	}

	public void setSalaireSouhaite(String salaireSouhaite) {
		this.salaireSouhaite = salaireSouhaite;
	}

}
