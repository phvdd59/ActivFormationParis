package com.formation.phva.beans.ajee;

import java.io.Serializable;
import java.util.Date;

public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int FEMINIM = 0;
	public static final int MASCULIN = 1;

	private int idPersonne;
	private String nom;
	private String prenom;
	private int sexe;
	private String identifiant;
	private String mdp;
	private String email;

	private String adresse;
	private String cp;
	private String ville;
	private String telFixe;
	private String telPort;
	private String fax;

	private Date dateNaissance;
	private String lieuNaissance;
	private String numSecu;
	private String nationalite;

	private String situation;
	private String fonction;
	private String positionEntreprise;
	private boolean cadre;
	private String coeff;
	private String salaire;

	private Date visiteMedicale;
	private String montantTransport;

	private boolean voiture;
	private int nbCV;
	private String nbKm;

	private boolean mutuelle;
	private boolean ticketResto;
	private Date dateCreation;
	private Date dateModification;
	private boolean bloque;
	private String raisonBlocage;

	public Personne() {
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

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
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

	public String getPositionEntreprise() {
		return positionEntreprise;
	}

	public void setPositionEntreprise(String positionEntreprise) {
		this.positionEntreprise = positionEntreprise;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
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
}