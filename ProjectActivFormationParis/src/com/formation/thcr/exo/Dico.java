package com.formation.thcr.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		String tmp = texte.toLowerCase().replaceAll("[^a-z]", " ");

		String[] tabMots = tmp.split(" ");

		ArrayList<Mot> mots = new ArrayList<Mot>();

		for (int i = 0; i < tabMots.length; i++) {
			Mot mot = new Mot(tabMots[i]);
			if (mots.indexOf(mot) == -1) {
				mots.add(mot);
			} else {
				mots.get(mots.indexOf(mot)).plusUn();
			}
		}

		//Creation des cledico
		for (int j = 1; j <= 26; j++) {
			for (int i = 'a'; i <= 'z'; i++) {
				CleDico cleDico = new CleDico(String.valueOf((char) i), j);
				this.put(cleDico, new ArrayList<Mot>());
			}
		}

		for (int i = 0; i < mots.size(); i++) {
			for (int k = 'a'; k < 'z'; k++) {
				if (mots.get(i).getMot().contains(String.valueOf((char) k))) {
					CleDico cle = new CleDico(String.valueOf((char) k),
							mots.get(i).getMot().length());
					this.get(cle).add(mots.get(i));
				}
			}
		}
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> listString = new ArrayList<String>();
		ArrayList<Mot> listMot = new ArrayList<Mot>();
		CleDico cleDico = new CleDico(lettre, lngMot);
		listMot = this.get(cleDico);
		Collections.sort(listMot);
		for (int i = 0; i < this.get(cleDico).size(); i++) {
			listString.add(listMot.get(i).getMot());
		}
		return listString;
	}

	public String epuration(String texte) {

		String tmp = texte.toLowerCase(); // ne rendre que des minuscules
		//remplacement caractère spéciaux 
		tmp = tmp.replace("'", " ");
		tmp = tmp.replace(",", " ");
		tmp = tmp.replace("é", "e");
		tmp = tmp.replace("è", "e");
		tmp = tmp.replace("ê", "e");
		tmp = tmp.replace("ç", "c");
		tmp = tmp.replace("à", "a");
		tmp = tmp.replace("?", " ");
		tmp = tmp.replace("!", " ");
		tmp = tmp.replace(".", " ");
		tmp = tmp.replace("\t", " ");
		tmp = tmp.replace("\n", " ");
		tmp = tmp.replace("   ", " ");
		tmp = tmp.replace("  ", " ");

		return tmp;

	}

}
