package com.formation.anfr.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>>implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		if (texte != null) {
			String[] texteTrie = traitementDeTexte(texte);
			// ArrayList<Mot> listeMot = triMots(texteTrie);
			// ajoutTreeMap(listeMot);
		}
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		CleDico clef = new CleDico(lettre, lngMot);
		ArrayList<Mot> listeMots = get(clef);
		ArrayList<String> listeString = new ArrayList<String>();
		if (listeMots != null) {
			Collections.sort(listeMots);
			for (Mot mot : listeMots) {
				String str = mot.getMot();
				listeString.add(str);
			}

		}
		return listeString;
	}

	private String[] traitementDeTexte(String texte) {
		String[] txt = {};
		char[] tab = texte.trim().toCharArray();
		for (char c : tab) {
			c = Character.toLowerCase(c);
			if (c == 'ח') {
				c = 'c';
			} else if (c > 'א' && c < 'ו') {
				c = 'a';
			} else if (c > 'ט' && c < 'כ'){
				c = 'e';
			} else if (c > 'ל' && c < 'ן') {
				c = 'i';
			} else if (c > 'ע' && c < 'צ') {
				c = 'o';
			} else if (c > 'ש' && c < 'ü') {
				c = 'u';
			} else if (c == 'ס') {
				c = 'n';
			} else if (c == 'ÿ') {
				c = 'y';
			} else {
				c = ' ';
			}
		}
		

//		texte = texte.toLowerCase();
		// "[.!,;()']"
//		texte = texte.replaceAll("\\W", " ");
//		texte = texte.replaceAll("[יטךכ]", "e");
//		texte = texte.replaceAll("[אגה]", "a");
//		texte = texte.replaceAll("[שüû]", "u");
//		texte = texte.replaceAll("[עצפ]", "u");
//		texte = texte.replace("  ", " ");
//		texte = texte.replace("  ", " ");
		String[] texteTrie = texte.split(" ");
		return texteTrie;
	}

	private ArrayList<Mot> triMots(String[] texteTrie) {
		ArrayList<Mot> liste = new ArrayList<Mot>();
		for (String sst : texteTrie) {
			Mot motTest = new Mot(sst);
			if (liste.contains(motTest)) {
				liste.get(liste.indexOf(motTest)).plusUn();
			} else {
				liste.add(motTest);
			}
		}
		return liste;
	}

	private void ajoutTreeMap(ArrayList<Mot> listeMot) {
		for (Mot mot : listeMot) {
			String strMot = mot.getMot();
			for (int i = 0; i < strMot.length(); i++) {
				CleDico clef = new CleDico(Character.toString(strMot.charAt(i)), strMot.length());
				ArrayList<Mot> listeClef = get(clef);
				if (listeClef == null) {
					listeClef = new ArrayList<Mot>();
					listeClef.add(mot);
					put(clef, listeClef);
				} else if (!listeClef.contains(mot)) {
					listeClef.add(mot);
					put(clef, listeClef);
				}
			}
		}
	}
}
