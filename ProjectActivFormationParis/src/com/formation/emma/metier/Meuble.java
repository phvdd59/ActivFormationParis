package com.formation.emma.metier;

import java.util.ArrayList;

public class Meuble implements Comparable<Meuble> {

	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ListeElmt lstElmt;
	private String notice;

	String unite = "mm";

	public Meuble(TRI tri, String nomCommercial, String refAbrege, String unite, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
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

		float a = this.longueur * this.largeur * this.hauteur;
		return a;
	}

	public void prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {

	}

	public int compareTo(Meuble o) {
		int compare = 2;
		if (tri == TRI.ALPHA) {
			if (getNomCommercial().compareTo(o.getNomCommercial()) < 0) {
				compare = -1;
			} else if (getNomCommercial().compareTo(o.getNomCommercial()) > 0) {
				compare = 1;
			}
		} else if (tri == TRI.REF) {
			if (getRefAbrege().compareTo(o.getRefAbrege()) < 0) {
				compare = -1;
			} else if (getRefAbrege().compareTo(o.getRefAbrege()) > 0) {
				compare = 1;
			}
		} else if (tri == TRI.VOLUME) {
			if (this.volume() < o.volume()) {
				compare = -1;
			} else if (this.volume() > o.volume()) {
				compare = 1;
			}
		}

		return compare;
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

	public ListeElmt getLstElmt() {
		return lstElmt;
	}

	public void setLstElmt(ListeElmt lstElmt) {
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
		return "Meuble [ nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", unite=" + unite + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + "]";
	}

}
