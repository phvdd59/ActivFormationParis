package com.formation.ajee.metier;

import java.sql.Timestamp;
import java.util.Date;

public class Personne {

	private int idPersonne;
	private String nom;
	private String prenom;
	private SEXE sexe;
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

	private SITUATION situation;
	private String fonction;
	private String position;
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
	private Timestamp dateModification;
	private boolean bloque;
	private String raisonBlocage;
	private ListeDoc listeDoc;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		String nomE = epuration(nom);
		String prenomE = epuration(prenom);
		this.identifiant = prenomE.substring(0, 1) + "." + nomE;
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

	public String epuration(String texte) {
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[ав]", "a");
		texte = texte.replaceAll("[йикл]", "e");
		texte = texte.replaceAll("щ", "u");
		texte = texte.replaceAll("з", "c");
		texte = texte.replaceAll("ф", "o");
		texte = texte.replaceAll("[оп]", "i");
		texte = texte.replaceAll("\\s+", " ");
		return texte;
	}
	
	
}