package com.formation.jeci.exo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.CleDico;
import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		ArrayList<Mot> texteModifié = new ArrayList<Mot>();
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
			texteModifié.add(mot);

		}
		for (int i = 0; i < texteModifié.size(); i++) {
			for (int j = 0; j < texteModifié.size(); j++) {

				if (texteModifié.get(i).getMot().equals((texteModifié.get(j).getMot())) && i != j) {
					texteModifié.remove(j);
					texteModifié.get(i).plusUn();
					j--;
				}
			}
		}
		Collections.sort(texteModifié);
		for (char i = 'a'; i < 'z'; i++) {
			for (int j = 0; j <= 26; j++) {
				CleDico key = new CleDico("i", j);
				ArrayList<Mot> dico = new ArrayList<Mot>();
				this.put(key, dico);

				for (int k = 0; k < texteModifié.size(); k++) {
					if (texteModifié.get(k).getMot().contains(Character.toString(i)) && texteModifié.get(k).getMot().length() == j) {
						dico.add(texteModifié.get(k));
					}
				}

			}
		}

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		CleDico clé = new CleDico(lettre, lngMot);
		ArrayList<Mot> listeDeMot = new ArrayList<Mot>();
		listeDeMot = this.ceilingEntry(clé).getValue();
		ArrayList<String> listeFinal = new ArrayList<String>();

		for (int i = 0; i < listeDeMot.size(); i++) {
			listeFinal.add(listeDeMot.get(i).getMot());
		}
		return listeFinal;
	}

}
