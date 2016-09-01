package com.formation.bait.metier;

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
	private String dateNaissance = new String();
	private String lieuNaissance = new String();
	private String numSecu = new String();
	private String nationalite = new String();
	private String situation = new String();
	private String fonction = new String();
	private String position = new String();
	private boolean cadre = false;
	private String coeff = new String();
	private String salaire = new String();
	private String visiteMedicale = new String();
	private String montantTransport = new String();
	private boolean voiture = false;
	private String nbCV = new String();
	private String ndKm = new String();
	private boolean mutuelle = false;
	private boolean ticket = false;
	private boolean admin = false;
	private String dateCreation = new String();
	private String dateModification = new String();
	private boolean bloque =false;
	private String raisonBlocage=new String();
	private ListeDoc listeDoc;

	public Personne(String identifiant, String mdp) {
		this.idPersonne = 0;
		this.identifiant = identifiant;
		this.prenom = "";
		this.nom = "";
		this.mdp = mdp;
		this.email = "";
		this.adresse = "";
		this.cP = "";
		this.ville = "";
		this.telFixe = "";
		this.telPort = "";
		this.fax= "";
		this.dateNaissance="";
		this.lieuNaissance ="";
		this.numSecu="";
		this.nationalite="";
		this.situation = "";
		this.fonction = "";
		this.position = "";
		this.coeff = "";
		this.salaire = "";
		this.visiteMedicale = "";
		this.montantTransport = "";
		this.nbCV = "";
		this.ndKm = "";
		this.dateCreation = "";
		this.dateModification ="";
		this.raisonBlocage = "";
		this.listeDoc = new ListeDoc();
		

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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
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

	public String getVisiteMedicale() {
		return visiteMedicale;
	}

	public void setVisiteMedicale(String visiteMedicale) {
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

	public String getNbCV() {
		return nbCV;
	}

	public void setNbCV(String nbCV) {
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

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateModification() {
		return dateModification;
	}

	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}

	public String getRaisonBlocage() {
		return raisonBlocage;
	}

	public void setRaisonBlocage(String raisonBlocage) {
		this.raisonBlocage = raisonBlocage;
	}

	public ListeDoc getListeDoc() {
		return listeDoc;
	}

	public void setListeDoc(ListeDoc listeDoc) {
		listeDoc = listeDoc;
	}

	
}
