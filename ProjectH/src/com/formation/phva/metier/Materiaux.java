package com.formation.phva.metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materiaux")
public class Materiaux {
	public static final Materiaux BOIS = new Materiaux("BOIS", 0.6f, SOLIDITE.NORMAL, 0);
	public static final Materiaux COMPENSE = new Materiaux("COMPENSE", 0.9f, SOLIDITE.NORMAL, 0);
	public static final Materiaux STRATIFIE = new Materiaux("STRATIFIE", 0.8f, SOLIDITE.NORMAL, 0);
	public static final Materiaux FER = new Materiaux("FER", 7.4f, SOLIDITE.SOLIDE, 0);
	public static final Materiaux BRONZE = new Materiaux("BRONZE", 9.2f, SOLIDITE.SOLIDE, 0);
	public static final Materiaux VERRE = new Materiaux("VERRE", 2.5f, SOLIDITE.FRAGILE, 0);
	public static final Materiaux TISSU = new Materiaux("TISSU", 1.1f, SOLIDITE.SOLIDE, 0);
	public static final Materiaux CARTON = new Materiaux("CARTON", 0.5f, SOLIDITE.FRAGILE, 0);
	public static final Materiaux VIDE = new Materiaux("VIDE", 0, SOLIDITE.FRAGILE, 0);
	public static final Materiaux PLASTIQUE = new Materiaux("PLASTIQUE", 0.5f, SOLIDITE.NORMAL, 0);
	public static final Materiaux CAOUTCHOU = new Materiaux("CAOUTCHOU", 1.1f, SOLIDITE.NORMAL, 0);
	public static final Materiaux BAMBOU = new Materiaux("BAMBOU", 0.6f, SOLIDITE.FRAGILE, 0);

	public static final Materiaux valueOf(String nom) {
		Materiaux mat = null;
		switch (nom) {
		case "BOIS":
			mat = BOIS.clone();
			break;
		case "COMPENSE":
			mat = COMPENSE.clone();
			break;
		case "STRATIFIE":
			mat = STRATIFIE.clone();
			break;
		case "FER":
			mat = FER.clone();
			break;
		case "BRONZE":
			mat = BRONZE.clone();
			break;
		case "VERRE":
			mat = VERRE.clone();
			break;
		case "CARTON":
			mat = CARTON.clone();
			break;
		case "VIDE":
			mat = VIDE.clone();
			break;
		case "PLASTIQUE":
			mat = PLASTIQUE.clone();
			break;
		case "CAOUTCHOU":
			mat = CAOUTCHOU.clone();
			break;
		case "BAMBOU":
			mat = BAMBOU.clone();
			break;
		}
		return mat;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_materiaux")
	private long id_materiaux;

	private String nom;
	private float densite;
	private int solidite;
	private int pourcent;

	@ManyToOne(cascade = CascadeType.ALL)
	private Elmt elmt;
	
	public Materiaux() {
	}

	public Materiaux(String nom, float densite, int solidite, int pourcent) {
		super();
		this.nom = nom;
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = pourcent;
	}

	public Materiaux getMateriaux(int pc) {
		Materiaux mat = clone();
		mat.setPourcent(pc);
		return mat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getDensite() {
		return densite;
	}

	public void setDensite(float densite) {
		this.densite = densite;
	}

	public int getSolidite() {
		return solidite;
	}

	public void setSolidite(int solidite) {
		this.solidite = solidite;
	}

	public int getPourcent() {
		return pourcent;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}

	public Materiaux clone() {
		Materiaux mat = new Materiaux(nom, densite, solidite, pourcent);
		return mat;
	}

	public long getId_materiaux() {
		return id_materiaux;
	}

	public void setId_materiaux(long id_materiaux) {
		this.id_materiaux = id_materiaux;
	}

	public Elmt getElmt() {
		return elmt;
	}

	public void setElmt(Elmt elmt) {
		this.elmt = elmt;
	}
}
