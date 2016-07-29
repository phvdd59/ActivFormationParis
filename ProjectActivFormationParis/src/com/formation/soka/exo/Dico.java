package com.formation.soka.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {
	/**
	 * Methode permettant d'eliminer les caractéres que l'on ne veut pas, +
	 * retirer les Maj
	 */
	@Override
	public void ranger(String texte) {
		texte = texte.toLowerCase();
		char[] tabChar = virerLesBadCaracteres(texte);
		ArrayList<String> listeMotsString = creerListeMotsString(tabChar);
		ArrayList<Mot> listeMotsMot = creerListeMotsMot(listeMotsString);
		ajouterCle(listeMotsMot);

	}

	private char[] virerLesBadCaracteres(String texte) {
		char[] tabChar = texte.toCharArray();
		for (int i = 0; i < tabChar.length; i++) {
			if (tabChar[i] == '\'' || tabChar[i] == ',' || tabChar[i] == '&' || tabChar[i] == '!' || tabChar[i] == '?' || tabChar[i] == ',' || tabChar[i] == ':' || tabChar[i] == '/') {
				tabChar[i] = ' ';
			}
			if (tabChar[i] == 'é' || tabChar[i] == 'è' || tabChar[i] == 'ê') {
				tabChar[i] = 'e';
			}
			if (tabChar[i] == 'à') {
				tabChar[i] = 'a';
			}
			if (tabChar[i] == 'ù') {
				tabChar[i] = 'u';
			}
			if (tabChar[i] == 'ç') {
				tabChar[i] = 'c';
			}

		}
		return tabChar;
	}

	private ArrayList<String> creerListeMotsString(char[] tabChar) {
		ArrayList<String> listeMotsString = new ArrayList<String>();
		String s = null;
		for (int i = 0; i < tabChar.length; i++) {
			if (tabChar[i] == ' ') {
				if (s != null) {
					listeMotsString.add(s);
					s = null;
				}
			} else {
				if (s == null) {
					s = Character.toString(tabChar[i]);
				} else {
					s = s.concat(Character.toString(tabChar[i]));
				}
			}
		}
		listeMotsString.add(s);

		return listeMotsString;
	}

	private ArrayList<Mot> creerListeMotsMot(ArrayList<String> listeMotsString) {
		ArrayList<Mot> listeMotsMot = new ArrayList<Mot>();

		for (int i = 0; i < listeMotsString.size(); i++) {
			Mot mot = new Mot(listeMotsString.get(i));
			if (listeMotsMot.contains(mot)) {
				int x = listeMotsMot.indexOf(mot);
				listeMotsMot.get(x).plusUn();
			} else {
				listeMotsMot.add(mot);
			}
		}
		Collections.sort(listeMotsMot);

		return listeMotsMot;
	}

	private void ajouterCle(ArrayList<Mot> listeMotsMot) {
		CleDico cleDico = null;
		for (int i = 0; i < listeMotsMot.size(); i++) {
			for (int j = 0; j < listeMotsMot.get(i).toString().length(); j++) {
				ArrayList<Mot> listeTempo = new ArrayList<Mot>();
				listeTempo.add(listeMotsMot.get(i));
				cleDico = new CleDico(listeMotsMot.get(i).toString().substring(j, j + 1), listeMotsMot.get(i).toString().length());
				if (this.containsKey(cleDico)) {
					ArrayList<Mot> lst = get(cleDico);
					if (lst.contains(listeMotsMot.get(i))) {
						Mot mot = lst.get(lst.indexOf(listeMotsMot.get(i)));
						mot.plusUn();
					}
					this.get(cleDico).add(listeMotsMot.get(i));
				} else {
					put(cleDico, listeMotsMot);
				}
			}
		}
	}

	/**
	 * Trouver les mots contenant la lettre <lettre> avec une certaine longueur
	 * <lngMot> Puis les trier par ordre d'utilisation puis par ordre
	 * alphabétique Utiliser les méthodes de la classe <Mot>
	 *
	 */
	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		CleDico cleDico = new CleDico(lettre, lngMot);
		ArrayList<Mot> listeMot = new ArrayList<Mot>();
		ArrayList<String> listeString = new ArrayList<String>();
		for (Mot mot : listeMot) {
			listeString.add(mot.getMot());
		}
		return listeString;
	}
}
