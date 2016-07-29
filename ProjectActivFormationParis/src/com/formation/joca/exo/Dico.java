package com.formation.joca.exo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	public Dico() {

		for (int i = 'a'; i <= 'z'; i++) {
			for (int j = 1; j <= 26; j++) {
				CleDico cle = new CleDico((String.valueOf((char) i)), j);
				this.put(cle, new ArrayList<Mot>());
			}
		}
	}

	@Override
	public void ranger(String texte) {
		ArrayList<Mot> texteRanger = traitementTexte(texte);

		for (int i = 0; i < texteRanger.size(); i++) {
			Mot mot = texteRanger.get(i);
			char[] tabLettre = mot.getMot().toCharArray();
			ArrayList<Character> tabFinal = new ArrayList<Character>();
			int j = 0;
			while (j < tabLettre.length) {
				if (tabFinal == null) {
					tabFinal.add(tabLettre[j]);
					j++;
				} else if (!tabFinal.contains((Character) tabLettre[j])) {
					tabFinal.add(tabLettre[j]);
					j++;
				} else {
					j++;
				}
			}
			for (int z = 0; z < tabFinal.size(); z++) {
				CleDico cle = new CleDico(Character.toString(tabFinal.get(z)), mot.getMot().length());
				if (this.get(cle) == null) {
					this.get(cle).add(mot);
				} else if (this.get(cle).indexOf(mot) == -1) {
					this.get(cle).add(mot);
				} else {
					for (int m = 1; m <= this.get(cle).get(this.get(cle).indexOf(mot)).getNb(); m++) {
						this.get(cle).get(this.get(cle).indexOf(mot)).plusUn();
					}
				}
			}
		}

	}

	public ArrayList<Mot> traitementTexte(String texte) {
		String texteModif = texte;

		texteModif = texteModif.toLowerCase();
		texteModif = Normalizer.normalize(texteModif, Normalizer.Form.NFD);
		texteModif = texteModif.replaceAll("\\p{M}", "");
		texteModif = texteModif.replaceAll("\\W", " ");
		texteModif = texteModif.replaceAll("\\s+", " ");
		String[] tabMots = texteModif.split(" ");

		ArrayList<Mot> listeMots = new ArrayList<Mot>();
		for (int i = 0; i < tabMots.length; i++) {
			Mot mot = new Mot(tabMots[i]);
			if (listeMots.indexOf(mot) == -1) {
				listeMots.add(mot);
			} else {
				listeMots.get(listeMots.indexOf(mot)).plusUn();
			}
		}
		return listeMots;
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> listeMots = new ArrayList<String>();
		CleDico cle = new CleDico(lettre, lngMot);
		ArrayList<Mot> listeClasse = new ArrayList<Mot>();
		listeClasse = this.get(cle);
		Collections.sort(listeClasse);
		for (int i = 0; i < listeClasse.size(); i++) {

			listeMots.add(listeClasse.get(i).getMot());
		}
		return listeMots;
	}

}
