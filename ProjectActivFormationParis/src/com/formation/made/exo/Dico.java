package com.formation.made.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		String TexteAEpurer = epuration(texte); // on utilise la méthode epurer pour epurer le texte
		String[] tabStringTexte = TexteAEpurer.split(" "); // on split

		for (int i = 0; i < tabStringTexte.length; i++) {
			Mot mot = new Mot(tabStringTexte[i]);
			for (int j = 0; j < tabStringTexte[i].length(); j++) {
				String lettre = tabStringTexte[i].substring(j, j + 1);
				CleDico cleDico = new CleDico(lettre, tabStringTexte[i].length());

				ArrayList<Mot> lst = this.get(cleDico);
				System.out.println(lst);
				this.put(cleDico, lst);
				lst.add(mot);
				put(cleDico, lst);
				System.out.println(lst.size());

			}
		}
	}

	public String epuration(String texte) {
		String texteepure = new String();
		String texteSansMaj = texte.toLowerCase(); // on met le texte en minuscule
		String[] caracspeciaux = { "!", "?", ".", "'", "  " }; // creer le tableau de la ponctuation pour le remplacer
		for (String string : caracspeciaux) {
			texte = texteSansMaj.replace(string, " ");
			texteSansMaj = texte;
		}
		texte = texte.replace("é", "e");
		texte = texte.replace("è", "e");
		texte = texte.replace("ê", "e");
		texte = texte.replace("à", "a");
		texte = texte.replace("â", "a");
		texte = texte.replace("ù", "u");
		texte = texte.replace("ô", "o");
		texteepure = texte;
		return texteepure;
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> lstString = new ArrayList<String>();
		ArrayList<Mot> lstMot = new ArrayList<Mot>();
		CleDico cleDico = new CleDico(lettre, lngMot);
		lstMot = get(cleDico);
		for (int i = 0; i < lstMot.size(); i++) {
			String stringMot = lstMot.get(i).getMot();
			lstString.add(stringMot);
		}
		return lstString;
	}

}
