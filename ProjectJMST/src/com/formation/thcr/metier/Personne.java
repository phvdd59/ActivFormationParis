package com.formation.thcr.metier;

import java.sql.Timestamp;
import java.util.Date;

public class Personne {

	private int idPersonne;  
	private String nom;  //alpha - ' espace
	private String prenom;  //idem qu'au dessus
	private SEXE sexe;
	private String identifiant; //min4 max25 alphanum - _ .
	private String mdp; //tout min6 
	private String email; //recuperer regex pour mail sur internet
	private String adresse; //alpha num - ' espace ()
	private String cp; //5 chiffres
	private String ville; // alpha ' - espace
	private String telFixe; // 9 entiers
	private String telPort; // 9 entiers
	private String fax; //9 entiers
	private Date dateNaissance; // JJ-MM-AAAA
	private String lieuNaissance; // comme ville
	private String numSecu; //(1|2)14 chiffres
	private String nationalite; //alpha - espace
	private String situation; //alpha - ' espace
	private String fonction; //alpha - ' espace
	private String position; // apha - ' espace
	private boolean cadre; 
	private String coeff; // 3 entiers
	private String salaire; // [0-9]+.[0-9]{2} annuel ? mensuel ?
	private Date visiteMedicale; //JJ-MM-AAAA
	private String montantTransport; //[0-9]+.[0-9]{2}
	private boolean voiture;
	private int nbCV; // des entiers
	private String nbKm; // des entiers
	private boolean mutuelle;
	private boolean ticketResto;
	private boolean admin;
	private Date dateCreation; //JJ-MM-AAAA
	private Timestamp dateModification; //HH-MM-SS JJ-MM-AAAA 
	private boolean bloque;
	private String raisonBlocage; //tout
	private ListeDoc listeDoc;

	public Personne() {
		super(); // initialiser les valeurs
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

	public SEXE getSexe() {
		return sexe;
	}

	public void setSexe(SEXE sexe) {
		this.sexe = sexe;
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

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
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

	public String getNbKm() {
		return nbKm;
	}

	public void setNbKm(String nbKm) {
		this.nbKm = nbKm;
	}

	public boolean isMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(boolean mutuelle) {
		this.mutuelle = mutuelle;
	}

	public boolean isTicketResto() {
		return ticketResto;
	}

	public void setTicketResto(boolean ticketResto) {
		this.ticketResto = ticketResto;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Timestamp getDateModification() {
		return dateModification;
	}

	public void setDateModification(Timestamp dateModification) {
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
		this.listeDoc = listeDoc;
	}

}
