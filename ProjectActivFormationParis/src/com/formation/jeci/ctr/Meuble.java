package com.formation.jeci.ctr;

import java.util.ArrayList;

public class Meuble implements Comparable<Meuble> {
	private TRI tri;
	private String nomCommercial;
	private String refAbrege;

	private float longueur;
	private float largeur;
	private float hauteur;
	private ListElmt lstElmt;
	private String notice;

	public Meuble(TRI tri, String nomCommercial, String unite, String refAbrege, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		switch (unite) {
		case "cm":
			this.longueur = longueur / 10;
			this.largeur = largeur / 10;
			this.hauteur = hauteur / 10;
			break;
		case "m":
			this.longueur = longueur / 1000;
			this.largeur = largeur / 1000;
			this.hauteur = hauteur / 1000;
			break;
		case "i":
			this.longueur = longueur * 25.4f;
			this.largeur = largeur * 25.4f;
			this.hauteur = hauteur * 25.4f;
			break;
		default:
			this.longueur = longueur;
			this.largeur = largeur;
			this.hauteur = hauteur;
			break;
		}

	}

	public Meuble(TRI tri, String nomCommercial, String refAbrege, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public void poids() {

	}

	public float volume() {
		float volume = longueur * largeur * hauteur;
		return volume;
	}

	public void prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {

	}

	public TRI getTri() {
		return tri;
	}

	public void setTri(TRI tri) {
		this.tri = tri;
	}

	public String getNomCommercial() {
		return nomCommercial;
	}

	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}

	public String getRefAbrege() {
		return refAbrege;
	}

	public void setRefAbrege(String refAbrege) {
		this.refAbrege = refAbrege;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
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

	public ListElmt getLstElmt() {
		return lstElmt;
	}

	public void setLstElmt(ListElmt lstElmt) {
		this.lstElmt = lstElmt;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public int compareTo(Meuble o) {
		int retour = -1;
		switch (o.getTri()) {
		case ALPHA:
			if (this.getNomCommercial().toString().compareTo(o.getNomCommercial().toString()) < 0) {
				retour = -1;
			} else if (this.getNomCommercial().toString().compareTo(o.getNomCommercial().toString()) > 0) {
				retour = 1;
			} else {
				retour = 0;
			}
			break;
		case REF:
			if (this.getRefAbrege().toString().compareTo(o.getRefAbrege().toString()) < 0) {
				retour = -1;
			} else if (this.getRefAbrege().toString().compareTo(o.getRefAbrege().toString()) > 0) {
				retour = 1;
			} else {
				retour = 0;
			}
			break;

		case VOLUME:

			if (this.volume() < (o.volume())) {
				retour = -1;
			} else if (this.volume() > (o.volume())) {
				retour = 1;
			} else {
				retour = 0;
			}
			break;

		default:
			break;
		}

		return retour;
	}

}
