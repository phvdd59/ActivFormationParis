package com.formation.thde.ctr;

import java.util.ArrayList;

public class Meuble implements Comparable<Meuble> {
	Tri tri;
	String nomCommercial;
	String refAbrege;
	String unite;
	float longueur;
	float largeur;
	float hauteur;

	public Meuble(Tri tri, String nomCommercial, String refAbrege, String unite, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.unite = unite;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public Meuble(Tri tri, String nomCommercial, String refAbrege, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.unite = "mm";
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int poids() {
		return 0;
	}

	public float volume() {
		return this.longueur * this.largeur * this.hauteur;
	}

	public int prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {
		return 0;
	}

	public Tri getTri() {
		return tri;
	}

	public void setTri(Tri tri) {
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

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
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

	@Override
	public String toString() {
		return "Meuble [tri=" + tri + ", nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", unite=" + unite + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + "]";
	}

	@Override
	public int compareTo(Meuble o) {
		int result = 0;

		if (this.tri == Tri.ALPHA) {
			result = (int) this.getNomCommercial().compareTo(o.getNomCommercial());
		} else if (this.tri == Tri.REF) {
			if (Integer.valueOf(this.getRefAbrege()) < Integer.valueOf(o.getRefAbrege())) {
				result = -1;
			} else if (Integer.valueOf(this.getRefAbrege()) > Integer.valueOf(o.getRefAbrege())) {
				result = 1;
			} else {
				result = 0;
			}
		} else if (this.tri == Tri.VOLUME) {
			if (this.volume() < o.volume()) {
				result = -1;
			} else if (this.volume() > o.volume()) {
				result = 1;
			} else {
				result = 0;
			}
		}
		return result;
	}

}