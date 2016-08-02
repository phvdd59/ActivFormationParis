package com.formation.jeci.exo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

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
		this.clear();

		for (char i = 'a'; i <= 'z'; i++) {
			for (int j = 1; j <= 26; j++) {
				CleDico key = new CleDico(Character.toString(i), j);
				ArrayList<Mot> dico = new ArrayList<Mot>();

				for (int k = 0; k < texteModifié.size(); k++) {
					if (texteModifié.get(k).getMot().contains(Character.toString(i)) && texteModifié.get(k).getMot().length() == j) {
						dico.add(texteModifié.get(k));

					}
				}
				if (dico.isEmpty() == false) {
					this.put(key, dico);
				}
				// System.out.println(dico);

			}

		}
		System.out.println(this.toString());

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		CleDico clé = new CleDico(lettre, lngMot);
		ArrayList<Mot> listeDeMot = new ArrayList<Mot>();
		listeDeMot.addAll(this.get(clé));
		ArrayList<String> listeFinal = new ArrayList<String>();

		for (int i = 0; i < listeDeMot.size(); i++) {
			listeFinal.add(listeDeMot.get(i).getMot());
		}
		return listeFinal;
	}
	// a

	@Override
	public String toString() {
		String retour = "";
		Set<java.util.Map.Entry<CleDico, ArrayList<Mot>>> set = entrySet();
		for (java.util.Map.Entry<CleDico, ArrayList<Mot>> entry : set) {
			ArrayList<Mot> lst = entry.getValue();
			retour += "[";
			for (int i = 0; i < lst.size(); i++) {
				Mot m = lst.get(i);
				retour += m.toString() + ",";

			}
			retour += "]\n";

		}
		return retour;
	}
}
