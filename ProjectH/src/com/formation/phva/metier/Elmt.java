package com.formation.phva.metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "elmt")
public class Elmt implements Comparable<Elmt> {
	public static final int TRI_REF = 0;
	public static final int TRI_ALPHA = 1;
	public static final int TRI_VOLUME = 2;
	public static int tri;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_elmt")
	private long id_elmt;
	
	@Column(name = "numero", nullable = false)
	private int numero;
	@Column(name = "nom", nullable = true)
	private String nom;
	@Column(name = "nb", nullable = true)
	private int nb;
	@Column(name = "longueur", nullable = true)
	private float longueur;
	@Column(name = "largeur", nullable = true)
	private float largeur;
	@Column(name = "hauteur", nullable = true)
	private float hauteur;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_materiaux")
	private ListeMateriaux listeMateriaux;

	public Elmt() {
	}

	public Elmt(int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		this(numero, nom, nb, longueur, largeur, hauteur);
		if (unite != null) {
			switch (unite) {
			case "mm":
				this.longueur = longueur;
				this.largeur = largeur;
				this.hauteur = hauteur;
				break;
			case "cm":
				this.longueur = longueur * 10;
				this.largeur = largeur * 10;
				this.hauteur = hauteur * 10;
				break;
			case "m":
				this.longueur = longueur * 1000;
				this.largeur = largeur * 1000;
				this.hauteur = hauteur * 1000;
				break;
			case "i":
				this.longueur = longueur * 25.4f;
				this.largeur = largeur * 25.4f;
				this.hauteur = hauteur * 25.4f;
				break;
			}
		}
	}

	public Elmt(int numero, String nom, int nb, float longueur, float largeur, float hauteur) {
		super();
		this.nom = nom;
		this.nb = nb;
		this.numero = numero;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.listeMateriaux = new ListeMateriaux();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getLongeur() {
		return longueur;
	}

	public void setLongeur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getHauteur() {
		return hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public ListeMateriaux getListeMateriaux() {
		return listeMateriaux;
	}

	public void setListeMateriaux(ListeMateriaux listeMateriaux) {
		this.listeMateriaux = listeMateriaux;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float volume() {
		return longueur * largeur * hauteur;
	}

	@Override
	public int compareTo(Elmt o) {
		int ret = 0;
		switch (tri) {
		case TRI_REF:
			ret = Integer.valueOf(numero).compareTo(Integer.valueOf(o.numero));
			break;
		case TRI_VOLUME:
			ret = Float.valueOf(volume()).compareTo(Float.valueOf(o.volume()));
			if (ret == 0) {
				ret = Integer.valueOf(numero).compareTo(Integer.valueOf(o.numero));
			}
			break;
		case TRI_ALPHA:
			ret = nom.compareTo(o.getNom());
			break;
		}
		return 0;
	}

	public float volumeL() {
		return longueur * largeur * hauteur / 1000000f;
	}

	public float poidMat(Materiaux mat) {
		return volumeL() * mat.getDensite() * mat.getPourcent() / 100f;
	}

	public float poid() {
		float pdTotal = 0f;
		for (Materiaux mat : listeMateriaux) {
			pdTotal += poidMat(mat);
		}
		return pdTotal;
	}

	public float prixFarication(float[] prMats) {
		return 0;
	}
}
