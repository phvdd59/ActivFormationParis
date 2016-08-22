package com.formation.beba.ctr;

import java.util.ArrayList;

public class Meuble implements Comparable<Meuble> {
	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ListeElmt lstElmnt;
	private String notice;

	public Meuble(TRI tri, String nomCommercial, String refAbrege, //
			String unite, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;

		if (unite.equals("cm")) {
			this.longueur = longueur * 10;
			this.largeur = largeur * 10;
			this.hauteur = hauteur * 10;
		}
		if (unite.equals("m")) {
			this.longueur = longueur * 1000;
			this.largeur = largeur * 1000;
			this.hauteur = hauteur * 1000;
		}
		if (unite.equals("1")) {
			this.longueur = longueur * 2.54f;
			this.largeur = largeur * 2.54f;
			this.hauteur = hauteur * 2.54f;
		}
		float volume = this.volume();
	}

	public Meuble(String nomCommercial, String refAbrege, String unite, float longueur, float largeur, float hauteur) {
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;

		if (unite.equals("cm")) {
			this.longueur = longueur * 10;
			this.largeur = largeur * 10;
			this.hauteur = hauteur * 10;
		}
		if (unite.equals("m")) {
			this.longueur = longueur * 1000;
			this.largeur = largeur * 1000;
			this.hauteur = hauteur * 1000;
		}
		if (unite.equals("1")) {
			this.longueur = longueur * 2.54f;
			this.largeur = largeur * 2.54f;
			this.hauteur = hauteur * 2.54f;
		}
		float volume = this.volume();
	}

	public void poids() {

	}

	public float volume() {
		float vol = this.longueur * this.largeur * this.hauteur;
		return vol;
	}

	public void prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {

	}

	@Override
	public int compareTo(Meuble o) {
		int compare = 0;
		if (this.tri.equals(TRI.ALPHA)) {
			compare = this.getNomCommercial().compareTo(o.getNomCommercial());
		} else if (this.tri.equals(TRI.REF)) {
			compare = this.getRefAbrege().compareTo(o.getRefAbrege());
		} else if (this.tri.equals(TRI.VOLUME)) {
			if (this.volume() < o.volume()) {
				compare = -1;
			} else if (this.volume() > o.volume()) {
				compare = 1;
			} else if (this.volume() == o.volume()) {
				compare = 0;
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

	public ListeElmt getLstElmnt() {
		return lstElmnt;
	}

	public void setLstElmnt(ListeElmt lstElmnt) {
		this.lstElmnt = lstElmnt;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Meuble [tri=" + tri + ", nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", lstElmnt=" + lstElmnt + ", notice=" + notice + "]";
	}

}
