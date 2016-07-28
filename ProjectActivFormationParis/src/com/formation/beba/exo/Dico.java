package com.formation.beba.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>>implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		ArrayList<Mot> motObj = new ArrayList<Mot>();
		char[] data = texte.toCharArray();
		for (int i = 0; i < data.length; i++) {
			if (data[i] == ',' || data[i] == '?' || data[i] == ';' || data[i] == '.' || data[i] == ':' || data[i] == '!' || data[i] == '-' || data[i] == '\'') {
				data[i] = ' ';
			}
			if ('A' <= data[i] && data[i] <= 'Z') {
				data[i] = Character.toLowerCase(data[i]);
			}
		}
		String motA = null;
		ArrayList<String> lstMot = new ArrayList<String>();
		for (int i = 0; i < data.length; i++) {
			if (data[i] == ' ') {
				if (motA != null) {

					lstMot.add(motA);
					motA = null;

				}
			} else {
				if (motA == null) {
					motA = Character.toString(data[i]);
				} else {
					motA = motA.concat(Character.toString(data[i]));
				}
			}
		}
		lstMot.add(motA);
		motA = null;
		for (int i = 0; i < lstMot.size(); i++) {
			if (motObj.contains(new Mot(lstMot.get(i)))) {
				motObj.get(motObj.lastIndexOf(lstMot.get(i))).plusUn();
			} else {
				motObj.add(new Mot(lstMot.get(i)));
			}
		}
		Collections.sort(lstMot);

		ArrayList<Mot> motMultiple = new ArrayList<Mot>();
		TreeMap<CleDico, ArrayList<Mot>> dico = new TreeMap<CleDico, ArrayList<Mot>>();

		for (int i = 0; i < motObj.size(); i++) {
			for (int j = 0; j < lstMot.get(i).length(); j++) {
				String lettre = Character.toString(motObj.get(i).getMot().charAt(j));
				int longM = motObj.get(i).getMot().length();
				CleDico cle = new CleDico(lettre, longM);
				if (dico.get(cle)==null) {
					dico.put(cle, motMultiple);
				}
				dico.
			
			}

		}
	}

	@Override
	public ArrayList<String> getListeMot(String stringlettre, int lngMot) {
		CleDico cle = new CleDico(stringlettre, lngMot);
		ArrayList<Mot> listeDeMot = get(cle);
		ArrayList<String> toutString = new ArrayList<String>();
		for (Mot mot : listeDeMot) {
			toutString.add(mot.getMot());
		}
		return toutString;
	}

}
