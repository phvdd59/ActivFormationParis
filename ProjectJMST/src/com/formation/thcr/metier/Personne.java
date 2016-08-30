package com.formation.thcr.metier;

import java.sql.Timestamp;

public class Personne {


	private String nom;
	private String prenom;
	private String login;
	private String motDePasse;
	private String mail;
	private String nationalite;
	private String adresse;
	private String telFixe;
	private String telPort;
	private String fax;
	private String ville;
	private String codePostal;
	private Timestamp dateNaissance;
	private String lieuNaissance;
	private String numSecu;
	private int id;
	private String position;
	private String coeff;
	private String salaire;
	private Timestamp visiteMedicale;
	private String montantTransport;
	private int nbCV;
	private String nbKm;
	private String situation;
	private Boolean voiture;
	private Boolean cadre;
	private Boolean mutuelle;
	private Boolean ticketResto;
	private boolean admin;

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
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}
	public String getTelPort() {
		return telPort;
	}
	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Timestamp getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Timestamp dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getNumSecu() {
		return numSecu;
	}
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCoeff() {
		return coeff;
	}
	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	public Timestamp getVisiteMedicale() {
		return visiteMedicale;
	}
	public void setVisiteMedicale(Timestamp visiteMedicale) {
		this.visiteMedicale = visiteMedicale;
	}
	public String getMontantTransport() {
		return montantTransport;
	}
	public void setMontantTransport(String montantTransport) {
		this.montantTransport = montantTransport;
	}
	public int getNbCV() {
		return nbCV;
	}
	public void setNbCV(int nbCV) {
		this.nbCV = nbCV;
	}
	public String getNbKm() {
		return nbKm;
	}
	public void setNbKm(String nbKm) {
		this.nbKm = nbKm;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public Boolean getVoiture() {
		return voiture;
	}
	public void setVoiture(Boolean voiture) {
		this.voiture = voiture;
	}
	public Boolean getCadre() {
		return cadre;
	}
	public void setCadre(Boolean cadre) {
		this.cadre = cadre;
	}
	public Boolean getMutuelle() {
		return mutuelle;
	}
	public void setMutuelle(Boolean mutuelle) {
		this.mutuelle = mutuelle;
	}
	public Boolean getTicketResto() {
		return ticketResto;
	}
	public void setTicketResto(Boolean ticketResto) {
		this.ticketResto = ticketResto;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
