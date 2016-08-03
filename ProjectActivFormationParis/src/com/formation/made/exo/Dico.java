package com.formation.made.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		String TexteEpure = epuration(texte); // on utilise la méthode epurer pour epurer le texte
		String[] tabStringTexte = TexteEpure.split(" "); // on split

		for (int i = 0; i < tabStringTexte.length; i++) {
			Mot mot = new Mot(tabStringTexte[i]);
			boolean premiere = true;
			for (int j = 0; j < tabStringTexte[i].length(); j++) {
				String lettre = tabStringTexte[i].substring(j, j + 1);
				CleDico cleDico = new CleDico(lettre, tabStringTexte[i].length());
				if (containsKey(cleDico)) {
					ArrayList<Mot> lst = this.get(cleDico);
					if (lst.contains(mot)) {
						mot = lst.get(lst.indexOf(mot)); // en gros si le mot appartient deja a la liste, on le reprend d'n la liste afin d'ajouter plus 1
						if (premiere) {
							mot.plusUn();
						}
					} else {
						lst.add(mot);
					}
				} else {
					ArrayList<Mot> lst = new ArrayList<Mot>();
					lst.add(mot);
					put(cleDico, lst);
				}
				premiere = false;
			}
		}
	}

	public String epuration(String texte) {
		String texteepure = new String();
		String texteSansMaj = texte.toLowerCase(); // on met le texte en minuscule
		char[] tabChar = texteSansMaj.toCharArray();
		for (int i = 0; i < tabChar.length; i++) {
			char v = tabChar[i];
			if (v >= 'à' && v <= 'ä') {
				tabChar[i] = 'a';
			}
			if (v >= 'é' && v <= 'ë') {
				tabChar[i] = 'e';
			}
			if (v >= 'ì' && v <= 'ï') {
				tabChar[i] = 'i';
			}
			if (v >= 'ö' && v <= 'ô') {
				tabChar[i] = 'o';
			}
			if (v >= 'ù' && v <= 'ü') {
				tabChar[i] = 'u';
			}
			if (v >= 'ç' && v <= 'ç') {
				tabChar[i] = 'c';
			}
			if (v < 'a' && v > 'z') {
				tabChar[i] = ' ';
			}

		}
		String texteepure2 = "";

		for (char c : tabChar) {
			texteepure2 += c;
		}

		texteepure2 = texteepure2.replace("\\p{Punct}", " "); // pour enlever la ponctuation
		texteepure2 = texteepure2.replace("\\s+", " "); // pour enlever les double triple .. espace
		texteepure = texteepure2;
		return texteepure;
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> lstString = new ArrayList<String>();
		ArrayList<Mot> lstMot = new ArrayList<Mot>();
		String let = epuration(lettre); // epuration de la lettre
		if (let.length() == 1 && let.equals(" ")) {// pour s'assurer qu'i s'agit bien d'une lettre
			CleDico cleDico = new CleDico(lettre, lngMot);
			if (containsKey(cleDico)) {
				ArrayList<Mot> lst = get(cleDico);
				Collections.sort(lst); // utilise le compare tout
				for (Mot mot : lst) {
					lstString.add(mot.getMot());
				}
			}
		}
		return lstString;
	}

}
