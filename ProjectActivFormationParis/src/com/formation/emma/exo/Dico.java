package com.formation.emma.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		texte = epuration(texte);
		String[] tab = texte.split(" ");

		for (int i = 0; i < tab.length; i++) {
			Mot mot = new Mot(tab[i]);
			boolean premiere = true;

			for (int j = 0; j < tab[i].length(); j++) {
				String lettre = tab[i].substring(j, j + 1);
				CleDico cleDico = new CleDico(lettre, tab[i].length());

				if (containsKey(cleDico)) {
					ArrayList<Mot> liste = get(cleDico);
					if (liste.contains(mot)) { // contains appel méthode equals
						mot = liste.get(liste.indexOf(mot));
						if (premiere) { // premiere lettre du mot (pour eviter d'ajouter plusieurs fois un mot qui contient plusieurs fois la meme lettre)
							mot.plusUn();
						}
					} else {
						liste.add(mot);
					}
				} else {
					ArrayList<Mot> liste = new ArrayList<Mot>();
					liste.add(mot);
					put(cleDico, liste);
				}
				premiere = false;
			}
		}
	}

	public String epuration(String texte) {
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[àâ]", "a");
		texte = texte.replaceAll("[éèêë]", "e");
		texte = texte.replaceAll("ù", "u");
		texte = texte.replaceAll("ç", "c");
		texte = texte.replaceAll("ô", "o");
		texte = texte.replaceAll("[îï]", "i");
		texte = texte.replaceAll("\\p{Punct}", "");
		texte = texte.replaceAll("  ", " ");
		return texte;
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> lstString = new ArrayList<String>();
		String let = epuration(lettre);
		if (let.length() == 1 && !let.equals(" ")) {
			CleDico cleDico = new CleDico(lettre, lngMot);
			if (containsKey(cleDico)) {
				ArrayList<Mot> lst = get(cleDico);
				Collections.sort(lst);
				for (Mot mot : lst) {
					lstString.add(mot.getMot());
				}
			}
		}
		return lstString;
	}

}
