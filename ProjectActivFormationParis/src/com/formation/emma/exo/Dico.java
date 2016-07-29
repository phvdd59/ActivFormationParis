package com.formation.emma.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		texte = epuration(texte);
		String[] tab = texte.split(" ");

		for (int i = 0; i < tab.length; i++) {
			Mot mot = new Mot(tab[i]);

			for (int j = 0; j < tab[i].length(); j++) {
				String lettre = tab[i].substring(j, j + 1);

				CleDico cleDico = new CleDico(lettre, tab[i].length());

//				for (int k = 0; k < size() - 1; k++) {
//						if (cleDico.compareTo(cleDico.get(i))) == 1) {
//							
//						}
											
		//		}
											
											ArrayList<Mot> liste = this.get(cleDico);

			}

		}

	}

	public String epuration(String texte) {
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[ав]", "a");
		texte = texte.replaceAll("[йикл]", "e");
		texte = texte.replaceAll("щ", "u");
		texte = texte.replaceAll("з", "c");
		texte = texte.replaceAll("ф", "o");
		texte = texte.replaceAll("[оп]", "i");
		texte = texte.replaceAll("\\p{Punct}", "");
		return texte;
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
