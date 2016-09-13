package com.formation.phva.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Perso1 {

	private String nom;
	private Date dateCreation;
	private Date datePromo;

	
	
	
	
	
	
	
	
	
	
	
	
	
	public Perso1() {

	}

	public Perso1(String nom, Date dateCreation, Date datePromo) throws InterruptedException,IllegalArgumentException {
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDatePromo() {
		return datePromo;
	}

	public void setDatePromo(Date datePromo) {
		this.datePromo = datePromo;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return "Perso [nom=" + nom + ", dateCreation=" + df.format(dateCreation) + ", datePromo=" + df.format(datePromo) + "]";
	}

}
