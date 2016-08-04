package com.formation.anfr.exo;

import java.awt.Point;

public class Terme {
	public static final boolean HORIZONTAL = false;
	public static final boolean VERTICAL = true;

	private String nom;
	private Point pos;
	private boolean sens;

	public Terme() {
	}

	public Terme(String nom, Point pos, boolean sens) {
		super();
		this.nom = epuration(nom);
		this.pos = pos;
		this.sens = sens;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = epuration(nom);
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public boolean isSens() {
		return sens;
	}

	public void setSens(boolean sens) {
		this.sens = sens;
	}

	public String epuration(String txt) {

		//		String tex = txt.replaceAll("\\s+", " ");
		//		
		//		String texte = Normalizer.normalize(txt, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		//		System.out.println(texte);
		String sRet = "";
		if (txt != null) {
			char[] tab = txt.trim().toLowerCase().toCharArray();
			for (int i = 0; i < tab.length; i++) {
				int v = tab[i];
				if (v >= 'à' && v <= 'å') {
					sRet += "a";
				} else if (v >= 'ç' && v <= 'ç') {
					sRet += "c";
				} else if (v >= 'è' && v <= 'ë') {
					sRet += "e";
				} else if (v >= 'ì' && v <= 'ï') {
					sRet += "i";
				} else if (v >= 'ò' && v <= 'ö') {
					sRet += "o";
				} else if (v >= 'ù' && v <= 'ü') {
					sRet += "u";
				} else if (v >= 'ý' && v <= 'ý') {
					sRet += "y";
				} else if (v >= 'a' && v <= 'z') {
					sRet += (char) v;
				} else {
					if (i != 0 && !sRet.substring(sRet.length() - 1).equals(" ")) {
						sRet += " ";
					}
				}
			}
		}
		return sRet.trim().toUpperCase();
	}

	@Override
	public String toString() {
		return nom + " (" + pos.y + "," + pos.x + "," + ((sens) ? "H" : "V") + ")";
	}
}