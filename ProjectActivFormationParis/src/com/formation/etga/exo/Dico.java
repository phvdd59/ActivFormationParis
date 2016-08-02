package com.formation.etga.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		//Remplacement de tous les charactères dont on ne veut plus. 
		texte = texte.toLowerCase();
		texte.replaceAll("[âäà]", "a");
		texte.replaceAll("[éèêë]", "e");
		texte.replaceAll("[îï]", "i");
		texte.replaceAll("[ôö]", "o");
		texte.replaceAll("[ûü]", "u");
		texte = texte.replaceAll("\\W", " ");

		texte.replaceAll("  ", " ");
		texte.replaceAll("   ", " ");
		texte.replaceAll("    ", " ");

		// On split le texte dans un tableau de mot
		String[] tabTexte = texte.split("[ ]");

		// On créé une ArrayList de mot
		ArrayList<Mot> listeMot = new ArrayList<Mot>();

		//Pour tous les mots du texte :
		for (int i = 0; i < tabTexte.length; i++) {
			Mot mot = new Mot(tabTexte[i]);
			// Si le mot existe, on incrémente son index dans la liste 
			if (listeMot.indexOf(mot) != -1) {
				listeMot.get(listeMot.indexOf(mot)).plusUn();
				// Si le mot n'existe pas, on l'ajoute à la liste
			} else {
				listeMot.add(mot);
			}
		}
		
		// Trier avec le compare to
		Collections.sort(listeMot);
		// pour toutes les lettres
		for (char i = 'a'; i <= 'z'; i++) {
			// pour tous les mots (le plus long on dit que c'est de 26 lettres)
			for (int j = 1; j <= 26; j++) {
				ArrayList<Mot> listeMotInter = new ArrayList<Mot>();
				for (int k = 0; k < listeMot.size(); k++) {
					if (listeMot.get(k).getMot().contains(Character.toString(i)) && (listeMot.get(k).getMot().length() == j)) {
						listeMotInter.add(listeMot.get(k));
					}
				}
				this.put(new CleDico(Character.toString(i), j), listeMotInter);
			}
		}
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String> listeString = new ArrayList<String>();
		ArrayList<Mot> listeMotFinale = new ArrayList<Mot>();
		CleDico cle = new CleDico(lettre, lngMot);
		listeMotFinale = this.get(cle);
		for (int i = 0; i < listeMotFinale.size(); i++) {
			listeString.add(listeMotFinale.get(i).toString());
		}
		return listeString;
	}
}
