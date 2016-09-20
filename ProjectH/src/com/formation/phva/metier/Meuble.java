package com.formation.phva.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meuble")
public class Meuble implements Comparable<Meuble> {
	public static final int TRI_REF = 0;
	public static final int TRI_ALPHA = 1;
	public static final int TRI_VOLUME = 2;

	public static void main(String[] args) throws Exception {
		Meuble m = new Meuble(TRI_ALPHA, "", "", "", 0, 0, 0);
		if (m != null) {
			System.out.println("qsdf");
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_meuble")
	private long id_meuble;

	public int tri;

	private String nomCommercial;
	private String refAbrege;

	private float longueur;
	private float largeur;
	private float hauteur;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meuble")
	private Set<Elmt> lstElmt;

	private String Notice;

	public Meuble(int tri, String nomCommercial, String refAbrege, String unite, float longueur, float largeur, float hauteur) throws Exception {
		super();
		tri = TRI_REF;
		if (nomCommercial != null) {
			this.nomCommercial = nomCommercial;
		} else {
			this.nomCommercial = "";
		}
		this.refAbrege = refAbrege;
		switch (unite) {
		case "mm":
			this.longueur = longueur;
			this.largeur = largeur;
			this.hauteur = hauteur;
			break;
		case "cm":
			this.longueur = longueur / 10;
			this.largeur = largeur / 10;
			this.hauteur = hauteur / 10;
			break;
		case "m":
			this.longueur = longueur * 1000;
			this.largeur = largeur * 1000;
			this.hauteur = hauteur * 1000;
			break;
		case "i":
			this.longueur = longueur / 25.4f;
			this.largeur = largeur / 25.4f;
			this.hauteur = hauteur / 25.4f;
			break;
		}
		this.lstElmt = new HashSet<Elmt>(0);
	}

	public Meuble(int tri, String nomCommercial, String refAbrege, float longueur, float largeur, float hauteur) {
		super();
		tri = TRI_REF;
		if (nomCommercial != null) {
			this.nomCommercial = nomCommercial;
		} else {
			this.nomCommercial = "";
		}
		this.refAbrege = refAbrege;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.lstElmt = new HashSet<Elmt>(0);
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

	public Set<Elmt> getLstElmt() {
		return lstElmt;
	}

	public String getNotice() {
		return Notice;
	}

	public void setNotice(String Notice) {
		this.Notice = Notice;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public void setLstElmt(Set<Elmt> lstElmt) {
		this.lstElmt = lstElmt;
	}

	public float poids() {
		return 0;
	}

	public float volume() {
		return hauteur * largeur * longueur;
	}

	public float prixVente(float taux, float promoPourcent, int iSolidite, ArrayList<Float> lstPrix) {
		return 0;
	}

	@Override
	public String toString() {
		return "[nom=" + nomCommercial + ", ref=" + refAbrege + "]";
	}

	@Override
	public int compareTo(Meuble o) {
		int ret = 0;
		switch (tri) {
		case TRI_REF:
			ret = refAbrege.compareTo(o.refAbrege);
			break;
		case TRI_VOLUME:
			ret = Float.valueOf(volume()).compareTo(Float.valueOf(o.volume()));
			if (ret == 0) {
				ret = refAbrege.compareTo(o.refAbrege);
			}
			break;
		case TRI_ALPHA:
			ret = nomCommercial.compareTo(o.getNomCommercial());
			break;
		}
		return 0;
	}
}