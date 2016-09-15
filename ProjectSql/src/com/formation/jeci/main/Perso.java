package com.formation.jeci.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Perso {

	private final String nom;
	private final Date dateCreation;
	private final Date datePromo;

//	public Perso() {
//
//	}

	public Perso(String nom, Date dateCreation, Date datePromo) throws InterruptedException, IllegalArgumentException {
		super();
		this.nom = nom;
		this.dateCreation = dateCreation;
		if (datePromo.compareTo(dateCreation) < 0) {
			throw new IllegalArgumentException("la date de promo ne peut être inférieur à la date de création");
		}
		Thread.sleep(100);
		this.datePromo = datePromo;
	}

	public String getNom() {
		return nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public Date getDatePromo() {
		Date dateCopie=new Date(datePromo.getTime());
		
		return dateCopie;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return "Perso [nom=" + nom + ", dateCreation=" + df.format(dateCreation) + ", datePromo=" + df.format(datePromo) + "]";
	}

}
