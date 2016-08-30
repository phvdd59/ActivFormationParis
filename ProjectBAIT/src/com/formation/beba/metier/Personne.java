package com.formation.beba.metier;

import java.sql.Timestamp;
import java.util.Date;


public class Personne {
	private int idPersonne;
	private String nom = new String();
	private String prenom = new String();
	private String identifiant = new String();
	private String mdp = new String();
	private String email = new String();
	private String adresse = new String();
	private String cP = new String();
	private String ville = new String();
	private String telFixe = new String();
	private String telPort = new String();
	private String fax = new String();
	private Date dateNaissance;
	private String lieuNaissance = new String();
	private String numSecu = new String();
	private String nationalite = new String();
	private String situation = new String();
	private String fonction = new String();
	private String position = new String();
	private boolean cadre;
	private String coeff = new String();
	private String salaire = new String();
	private Date visiteMedicale;
	private String montantTransport = new String();
	private boolean voiture;
	private int nbCV;
	private String ndKm = new String();
	private boolean mutuelle;
	private boolean ticket = false;
	private boolean admin;
	private Date dateCreation;
	private Timestamp dateModification;
	private boolean bloque;
	private String raisonBlocage=new String();
	private ListeDoc ListeDoc;

	public Personne(String identifiant, String mdp) {

		this.identifiant = identifiant;
		this.prenom = "";
		this.nom = "";
		this.mdp = mdp;

		this.fonction = "";
		this.position = "";
		this.salaire = "";
		this.ticket = false;
		this.cadre = false;
		this.coeff = "";
		this.adresse = "";
		this.cP = "";
		this.ville = "";
		this.email = "";

	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
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

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public Date getVisiteMedicale() {
		return visiteMedicale;
	}

	public void setVisiteMedicale(Date visiteMedicale) {
		this.visiteMedicale = visiteMedicale;
	}

	public String getMontantTransport() {
		return montantTransport;
	}

	public void setMontantTransport(String montantTransport) {
		this.montantTransport = montantTransport;
	}

	public boolean isVoiture() {
		return voiture;
	}

	public void setVoiture(boolean voiture) {
		this.voiture = voiture;
	}

	public int getNbCV() {
		return nbCV;
	}

	public void setNbCV(int nbCV) {
		this.nbCV = nbCV;
	}

	public String getNdKm() {
		return ndKm;
	}

	public void setNdKm(String ndKm) {
		this.ndKm = ndKm;
	}

	public boolean isMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(boolean mutuelle) {
		this.mutuelle = mutuelle;
	}

	public boolean isTicket() {
		return ticket;
	}

	public void setTicket(boolean ticket) {
		this.ticket = ticket;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
}
