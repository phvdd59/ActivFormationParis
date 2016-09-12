package com.formation.made;

import java.util.Date;

public class Perso {

	
	private final String nom;
	private final Date dateCreation;
	private final Date datePromo;

	

	
	
	public Perso(String nom, Date dateCreation, Date datePromo) {
		super();
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.datePromo = datePromo;
	}
	
	
	public String getNom() {
		
		return nom;
	}

	public Date getDateCreation() {
		Date dateCopie=new Date(dateCreation.getTime());//on cree une copie pour empecher de modifier la date de promo. on peut modifier seulement la date de copie
		return dateCopie;
	}

	public Date getDatePromo() {
		Date dateCopie=new Date(datePromo.getTime());//on cree une copie pour empecher de modifier la date de promo. on peut modifier seulement la date de copie
		return dateCopie;
	}


	@Override
	public String toString() {
		return "Perso [nom=" + nom + ", dateCreation=" + dateCreation + ", datePromo=" + datePromo + "]";
	}

	
}
