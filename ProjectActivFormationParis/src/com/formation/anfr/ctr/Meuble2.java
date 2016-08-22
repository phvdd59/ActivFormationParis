package com.formation.anfr.ctr;

import java.util.ArrayList;

public class Meuble2 implements Comparable<Meuble2> {
	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longeur;
	private float largeur;
	private float hauteur;
	private ListeElmt lstElmnt;
	private String notice;

	public Meuble2(TRI tRI, String nomCommercial, String refAbrege, String unite, float longeur, float largeur,
			float hauteur) {
		tri = tRI;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		if (unite.equals("cm")) {
			this.longeur = longeur * 10;
			this.largeur = largeur * 10;
			this.hauteur = hauteur * 10;
		} else if (unite.equals("m")) {
			this.longeur = longeur * 100;
			this.largeur = largeur * 100;
			this.hauteur = hauteur * 100;
		} else if (unite.equals("i")) {
			this.longeur = longeur * 25.4f;
			this.largeur = largeur * 25.4f;
			this.hauteur = hauteur * 25.4f;
		} else {
			this.longeur = longeur;
			this.largeur = largeur;
			this.hauteur = hauteur;
		}
	}

	public Meuble2(TRI tRI, String nomCommercial, String refAbrege, float longeur, float largeur, float hauteur) {
		super();
		tri = tRI;
		this.nomCommercial = nomCommercial;
		this.refAbrege = refAbrege;
		this.longeur = longeur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public void poids() {

	}

	public void prix(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {

	}
	
	public float volume(){
		float volume = hauteur*largeur*longeur;
		return volume;
	}

	public TRI getTRI() {
		return this.tri;
	}

	public void setTRI(TRI tRI) {
		tri = tRI;
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

	public float getLongeur() {
		return longeur;
	}

	public void setLongeur(float longeur) {
		this.longeur = longeur;
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

	public ListeElements getLstElmnt() {
		return lstElmnt;
	}

	public void setLstElmnt(ListeElements lstElmnt) {
		this.lstElmnt = lstElmnt;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public int compareTo(Meuble2 arg0) {
		int compare = 0;
		if(tri.equals(TRI.ALPHA)){
			compare = this.getNomCommercial().compareTo(arg0.getNomCommercial());
		}
		else if(tri.equals(TRI.REF)){
			compare =this.getRefAbrege().compareTo(arg0.getRefAbrege());
		}
		else {
			if (this.volume()>arg0.volume()){
				compare = 1;
			} else if (this.volume()<arg0.volume()){
				compare = -1;
			}
		}
		
		return compare;
	}

	@Override
	public String toString() {
		return "Meuble [nomCommercial=" + nomCommercial + "]";
	}

}
