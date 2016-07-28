package com.formation.jeci.exo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		ArrayList<Mot> texteModifi� = new ArrayList<Mot>();
		texte = Normalizer.normalize(texte, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		texte = texte.toLowerCase();
		texte = texte.replaceAll("\\W", " ");// regex \ attentionapres
												// charactere special, \W =
												// charactere REgex tout ce qui
												// n'est pas une lettre
		texte = texte.replaceAll("\\s+", " ");// Regex \s = espace;

		String[] tabTexte = texte.split(" ");
		for (int i = 0; i < tabTexte.length; i++) {
			Mot mot = new Mot(tabTexte[i]);
			texteModifi�.add(mot);

		}
		for (int i = 0; i < texteModifi�.size(); i++) {
			for (int j = 0; j < texteModifi�.size(); j++) {

				if (texteModifi�.get(i).getMot().equals((texteModifi�.get(j).getMot())) && i != j) {
					texteModifi�.remove(j);
					texteModifi�.get(i).plusUn();
					j--;
				}
			}
		}
		Collections.sort(texteModifi�);
		for (char i = 'a'; i < 'z'; i++) {
			for (int j = 0; j <= 26; j++) {
				CleDico key = new CleDico(Character.toString(i), j);
				ArrayList<Mot> dico = new ArrayList<Mot>();

				for (int k = 0; k < texteModifi�.size(); k++) {
					if (texteModifi�.get(k).getMot().contains(Character.toString(i)) && texteModifi�.get(k).getMot().length() == j) {
						dico.add(texteModifi�.get(k));
					}
				}
				this.put(key, dico);

			}
		}

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		CleDico cl� = new CleDico(lettre, lngMot);
		ArrayList<Mot> listeDeMot = new ArrayList<Mot>();
		listeDeMot = this.get(cl�);
		ArrayList<String> listeFinal = new ArrayList<String>();

		for (int i = 0; i < listeDeMot.size(); i++) {
			listeFinal.add(listeDeMot.get(i).getMot());
		}
		return listeFinal;
	}
	// a
}
