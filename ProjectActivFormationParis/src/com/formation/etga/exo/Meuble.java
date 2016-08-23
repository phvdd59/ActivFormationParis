package com.formation.etga.exo;

import java.util.ArrayList;

public class Meuble {

	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ListeElmt lstElmt;
	private String notice;

	public Meuble(TRI tri, String nomCommercial, String refAbrege, String unite, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		if ((unite == "cm") || (unite == "m") || (unite == "i")) {
			unite = unite;
		} else {
			unite = "mm";
		}
	}

	public Meuble(TRI tri, String nomCommercial, String refAbrege, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
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

	public void poids() {
	}

	public float volume() {
		float volume = hauteur * largeur * longueur;
		return volume;
	}

	public void prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {
	}

	@Override
	public String toString() {
		return "Meuble [tri=" + tri + ", nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", notice=" + notice + "]";
	}

}
