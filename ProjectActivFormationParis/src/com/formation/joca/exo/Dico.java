package com.formation.joca.exo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.CleDico;
import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	public Dico() {

		for (char i = 'a'; i <= 'z'; i++) {
			for (int j = 1; j <= 26; j++) {
				CleDico cle = new CleDico("i", j);
				this.put(cle, new ArrayList<Mot>());
			}
		}
	}

	@Override
	public void ranger(String texte) {
		ArrayList<Mot> texteRanger = traitementTexte(texte);
		for (int i = 0; i < texteRanger.size(); i++) {
			Mot mot = texteRanger.get(i);
			CleDico cle = new CleDico(Character.toString(mot.getMot().charAt(0)), mot.getMot().length());
			if (this.get(cle).indexOf(mot) == -1) {
				this.get(cle).add(mot);
			} else {
				for (int z = 1; z <= mot.getNb(); z++) {
					this.get(cle).get(this.get(cle).indexOf(mot)).plusUn();
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
		// TODO Auto-generated method stub
		return null;
	}

}
