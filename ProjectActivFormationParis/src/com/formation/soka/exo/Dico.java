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
		ajouterClesTreeMap(listeMotsMot);

	}

	private char[] virerLesBadCaracteres(String texte) {
		char[] tabChar = texte.toCharArray();
		for (int i = 0; i < tabChar.length; i++) {
			int x = tabChar[i];
			if (x == '\'' || x == ',' || x == '.' || x == '&' || x == '!' || x == '_' || x == '(' || x == ')' || x == '[' || x == ']' || x == '{' || x == '}' || x == '"' || x == '&' || x == '@' || x == '+' || x == '=' || x == '*' || x == '°' || x == '-' || x == '?' || x == ',' || x == ':'
					|| x == '/' || x == ';') {
				tabChar[i] = ' ';
			}
			if (x >= 'è' && x <= 'ë') {
				tabChar[i] = 'e';
			}
			if (x >= 'à' && x <= 'æ') {
				tabChar[i] = 'a';
			}
			if (x >= 'ù' && x <= 'ü') {
				tabChar[i] = 'u';
			}
			if (x >= 'ò' && x <= 'ö') {
				tabChar[i] = 'o';
			}
			if (x >= 'ì' && x <= 'ï') {
				tabChar[i] = 'i';
			}
			if (tabChar[i] == 'ç') {
				tabChar[i] = 'c';
			}
			if (tabChar[i] == 'ý') {
				tabChar[i] = 'y';
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

	private void ajouterClesTreeMap(ArrayList<Mot> listeMotsMot) {
		boolean premiere = true;
		CleDico cleDico = null;
		for (int i = 0; i < listeMotsMot.size(); i++) {
			for (int j = 0; j < listeMotsMot.get(i).toString().length(); j++) {
				//				ArrayList<Mot> listeTempo = new ArrayList<Mot>();
				//				listeTempo.add(listeMotsMot.get(i));
				cleDico = new CleDico(listeMotsMot.get(i).toString().substring(j, j + 1), listeMotsMot.get(i).toString().length());
				ArrayList<Mot> lst = get(cleDico);
				if (this.containsKey(cleDico)) {

					if (lst.contains(listeMotsMot.get(i))) {
						Mot mot = lst.get(lst.indexOf(listeMotsMot.get(i)));
						//						if (premiere) {
						//							mot.plusUn();
						//						}
					} else {
						lst.add(listeMotsMot.get(i));
					}
					//this.get(cleDico).add(listeMotsMot.get(i));
				} else {
					//ArrayList<Mot> 
					lst = new ArrayList<Mot>();
					lst.add(listeMotsMot.get(i));
					put(cleDico, lst);
				}
				premiere = false;
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
	public ArrayList<String> getListeMot(String lettre, int longueurMot) {
		ArrayList<Mot> listeMot = new ArrayList<Mot>();
		ArrayList<String> listeString = new ArrayList<String>();
		CleDico cleDico = new CleDico(lettre, longueurMot);
		for (Mot mot : listeMot) {
			listeString.add(mot.getMot());
		}
		return listeString;
	}
}
