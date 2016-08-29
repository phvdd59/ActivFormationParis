package com.formation.ajee.metier;

import java.util.Date;

public class UserETGA {

	private String nom;
	private String prenom;
	private String identifiant;
	private String mdp;
	private String adresse;
	private String cp;
	private String telFixe;
	private String telPortable;
	private String fax;
	private String email;
	private Date date;
	private String lieu;
	private String numSecu;
	private String nationalite;
	private String situation;
	private String fonction;
	private String position;
	private String coeficient;
	private String salaire;
	private String mutuelle;
	private String ticketResto;
	private String visiteMedical;
	private String transport;
	private String vehicule;
	private String kmMesure;
	
	public UserETGA() {
	}
	
	public UserETGA(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		String nom2 = nom.replace(" ", "");
		this.identifiant = prenom.substring(0, 1) + "." + nom2;
		while (mdp.length() != 8) {
			int a = (int) (Math.random() * 123);
			char lettre = (char) a;
			if (a > 47 && a < 58) {
				mdp = mdp + lettre;
			} else if (a > 96 && a < 123) {
				mdp = mdp + lettre;
			} else if (a > 64 && a < 91) {
				mdp = mdp + lettre;
			}
		}
	}

	public UserETGA(String nom, String prenom, String adresse, 
			String cp, String telFixe, String telPortable, String fax, 
			String email, Date date, String lieu, String numSecu, 
			String nationalite, String situation, String fonction, 
			String position, String coeficient, String salaire, 
			String mutuelle, String ticketResto, String visiteMedical, 
			String transport, String vehicule, String kmMesure) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.telFixe = telFixe;
		this.telPortable = telPortable;
		this.fax = fax;
		this.email = email;
		this.date = date;
		this.lieu = lieu;
		this.numSecu = numSecu;
		this.nationalite = nationalite;
		this.situation = situation;
		this.fonction = fonction;
		this.position = position;
		this.coeficient = coeficient;
		this.salaire = salaire;
		this.mutuelle = mutuelle;
		this.ticketResto = ticketResto;
		this.visiteMedical = visiteMedical;
		this.transport = transport;
		this.vehicule = vehicule;
		this.kmMesure = kmMesure;
	}

}
