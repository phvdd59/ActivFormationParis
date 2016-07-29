package com.formation.soka.exo;

import java.util.ArrayList;
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
		associerCle(listeMotsMot);

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
				i++;
				if (s != null) {
					listeMotsString.add(s);
					s = null;
				} else {
					i--;
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
		return listeMotsMot;
	}

	private void associerCle(ArrayList<Mot> listeMotsMot) {
		
	}

	/**
	 * Trouver les mots contenant la lettre <lettre> avec une certaine longueur
	 * <lngMot> Puis les trier par ordre d'utilisation puis par ordre
	 * alphabétique Utiliser les méthodes de la classe <Mot>
	 */
	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub

		return null;
	}
}
