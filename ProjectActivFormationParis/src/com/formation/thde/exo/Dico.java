package com.formation.thde.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		// ENLEVER LES ACCENTS

		texte = texte.toLowerCase();
		texte.replaceAll("[יטךכ]", "e");
		texte.replaceAll("[גהא]", "a");
		texte.replaceAll("[מן]", "i");
		texte.replaceAll("[ûü]", "u");
		texte.replaceAll("[פצ]", "o");
		texte = texte.replaceAll("\\W", " ");
		ArrayList<Mot> listMots = new ArrayList<Mot>(); //mot ?
		String[] tabTexte = texte.split(" ");
		for (int i = 0; i < tabTexte.length; i++) {
			Mot temp = new Mot(tabTexte[i]);
			if (listMots.indexOf(temp) != -1) {
				//marche pas on y passe jamais
				listMots.get(listMots.indexOf(temp)).plusUn();
			} else {
				listMots.add(temp);
			}
		}
		Collections.sort(listMots);
		for (char i = 'a'; i <= 'z'; i++) {
			for (int j = 1; j <= 26; j++) {
				ArrayList<Mot> listMots2 = new ArrayList<Mot>();
				for (int k = 0; k < listMots.size(); k++) {
					if (listMots.get(k).getMot().contains(Character.toString(i)) && (listMots.get(k).getMot().length() == j)) {
						listMots2.add(listMots.get(k));
					}
				}
				this.put(new CleDico(Character.toString(i), j), listMots2);
			}
		}
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> listString = new ArrayList<String>();
		ArrayList<Mot> listMots3 = new ArrayList<Mot>();
		CleDico clef = new CleDico(lettre, lngMot);
		listMots3 = this.get(clef);
		for (int i = 0; i < listMots3.size(); i++) {
			listString.add(listMots3.get(i).toString());
		}
		return listString;
	}

}
