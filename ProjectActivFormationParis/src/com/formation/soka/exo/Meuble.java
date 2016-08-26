package com.formation.soka.exo;

import java.util.ArrayList;

import com.formation.soka.a.TRI;

public class Meuble implements Comparable<Meuble> {

	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ListeElmt listElmt;
	private String notice;

	public Meuble(TRI tri, String nomCommercial, String refAbrege, String unite, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		unite = "mm";
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
		float volume = this.getLongueur() * this.getLargeur() * this.getHauteur();
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

	public ListeElmt getListElmt() {
		return listElmt;
	}

	public void setListElmt(ListeElmt listElmt) {
		this.listElmt = listElmt;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Meuble [tri=" + tri + ", nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", lsitElmt=" + listElmt + ", notice=" + notice + "]";
	}

	@Override
	public int compareTo(Meuble o) {
		int x = 0;
		if (tri.equals(TRI.VOLUME)) {
			if (volume() < o.volume()) {
				x = 1;
			} else if (volume() > o.volume()) {
				x = -1;
			} else {
				x = 0;
			}

		} else if (tri.equals(TRI.ALPHA)) {
			x = this.getNomCommercial().compareTo(o.getNomCommercial());
		} else if (tri.equals(TRI.REF)) {
			x = this.getRefAbrege().compareTo(o.getRefAbrege());
		}
		return x;
	}
}
