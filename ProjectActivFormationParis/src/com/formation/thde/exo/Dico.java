package com.formation.thde.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		//		if (texte == null || texte == "") {
		//
		//		} else {
		texte = texte.toLowerCase();
		texte.replaceAll("[éèêë]", "e");
		texte.replaceAll("[âäàáåãæ]", "a");
		texte.replaceAll("[îïíì]", "i");
		texte.replaceAll("[ûúüù]", "u");
		texte.replaceAll("[ôóõøöœò]", "o");
		texte.replaceAll("ç", "c");
		texte.replaceAll("ÿ", "y");
		texte.replaceAll("š", "s");
		texte.replaceAll("ñ", "n");
		texte.replaceAll("ž", "z");
		texte = texte.replaceAll("\\W", " ");
		texte.replaceAll("   ", " ");
		texte.replaceAll("  ", " ");
		ArrayList<Mot> listMots = new ArrayList<Mot>();
		String[] tabTexte = texte.split(" ");
		for (int i = 0; i < tabTexte.length; i++) {
			Mot temp = new Mot(tabTexte[i]);
			if (listMots.indexOf(temp) != -1) {
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
				if (listMots2.isEmpty() == false) {
					this.put(new CleDico(Character.toString(i), j), listMots2);
				}
			}
		}
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {

		ArrayList<String> listString = new ArrayList<String>();
		ArrayList<Mot> listMots3 = new ArrayList<Mot>();
		CleDico clef = new CleDico(lettre, lngMot);
		listMots3 = this.get(clef);
		// IIIIIIIIFFFFFFFF
		if (listMots3!=null){
		for (int i = 0; i < listMots3.size(); i++) {
			listString.add(listMots3.get(i).toString());
		}
		}
		return listString;
	}

	public String toString() {
		String s = "";
		Set<java.util.Map.Entry<CleDico, ArrayList<Mot>>> set = entrySet();
		for (java.util.Map.Entry<CleDico, ArrayList<Mot>> entry : set) {
			s += entry.getKey().toString() + " : ";
			ArrayList<Mot> lst = entry.getValue();
			Collections.sort(lst);
			for (int i = 0; i < lst.size(); i++) {
				Mot mot = lst.get(i);
				s += mot.toString();
				if (i != lst.size() - 1) {
					s += ",";
				}
			}
			s += "\n";
		}
		return s;
	}
}
