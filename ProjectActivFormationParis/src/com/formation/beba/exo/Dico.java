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
		boolean enCours = false;
		for (int i = 0; i < lstMot.size(); i++) {
			enCours = false;
			Mot motTemp = new Mot(lstMot.get(i));
			for (int j = 0; j < motObj.size(); j++) {

				if (motObj.get(j).equals(motTemp)) {
					motObj.get(j).plusUn();
					enCours = true;
				}
			}
			if (enCours == false) {
				motObj.add(new Mot(lstMot.get(i)));
			}
		}
		Collections.sort(motObj);

		for (int i = 0; i < motObj.size(); i++) {
			int t = motObj.get(i).toString().length();
			for (int j = 0; j < motObj.get(i).toString().length(); j++) {
				String lettre = Character.toString(motObj.get(i).getMot().charAt(j));
				int longM = motObj.get(i).getMot().length();
				CleDico cle = new CleDico(lettre, longM);
				
				if (this.get(cle) == null) {
					ArrayList<Mot> motMultiple = new ArrayList<Mot>();
					motMultiple.add(motObj.get(i));
					this.put(cle, motMultiple);
				} else {
					ArrayList<Mot> motMultiple = new ArrayList<Mot>();
					motMultiple = this.get(cle);
					motMultiple.add(motObj.get(i));
					this.put(cle, motMultiple);
				}

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
