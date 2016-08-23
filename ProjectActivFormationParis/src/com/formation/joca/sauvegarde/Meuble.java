package com.formation.joca.sauvegarde;

import java.util.ArrayList;

public class Meuble implements Comparable<Object> {

	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ListeElmt lstElmt;
	private String Notice;

	public Meuble(TRI tri, String nomCommercial, String refAbrege, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public Meuble(TRI tri, String nomCommercial, String refAbrege, String unite, float longueur, float largeur,
			float hauteur) {
		super();
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;

		if (unite.equals("cm")) {
			this.longueur = longueur / 10;
			this.largeur = largeur / 10;
			this.hauteur = hauteur / 10;
		} else if (unite.equals("m")) {
			this.longueur = longueur / 1000;
			this.largeur = largeur / 1000;
			this.hauteur = hauteur / 1000;
		} else if (unite.equals("i")) {
			this.longueur = longueur / (float) 25.4;
			this.largeur = largeur / (float) 25.4;
			this.hauteur = hauteur / (float) 25.4;
		}
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
		return Notice;
	}

	public void setNotice(String notice) {
		Notice = notice;
	}

	public double poids() {
		return 0;
	}

	public double volume() {
		return largeur * longueur * hauteur;
	}

	public void prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {

	}

	@Override
	public String toString() {
		return "Meuble [tri=" + tri + ", nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", longueur="
				+ longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", lstElmt=" + lstElmt + ", Notice="
				+ Notice + "]";
	}

	@Override
	public int compareTo(Object o) {
		int result = 0;
		Meuble obj = (Meuble) o;
		if (this.tri.equals(TRI.ALPHA)) {

			result = this.nomCommercial.compareTo(obj.getNomCommercial());

		} else if (this.tri.equals(TRI.REF)) {

			result = this.refAbrege.compareTo(obj.getRefAbrege());

		} else if (this.tri.equals(TRI.VOLUME)) {

			if (this.volume() < obj.volume()) {
				result = -1;
			} else if (this.volume() > obj.volume()) {
				result = 1;
			} else if (this.volume() == obj.volume()) {
				result = 0;
			}

		}
		return result;
	}
}
