package com.formation.ambr.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		//1.Hacher le texte sous forme de mots
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[אג]", "a");
		texte = texte.replaceAll("[יטכ]", "e");
		texte = texte.replaceAll("ן", "a");
		texte = texte.replaceAll("[פצ]", "a");
		texte = texte.replaceAll("[ûü]", "a");
		texte = texte.replaceAll("ח", "c");
		texte = texte.replaceAll("\\p{Punct}", "");
		//texte = texte.replaceAll("\\W", "");
		String[] tab = texte.split(" ");

		ArrayList<String> texteRange0 = new ArrayList<String>();
		for (int i = 0; i < tab.length; i++) {
			texteRange0.add(tab[i]);
			//String.valueOf(tab[i]);
		}

		ArrayList<Mot> texteRange = new ArrayList<Mot>();
		for (int i = 0; i < texteRange0.size(); i++) { // pour une liste c'est .size() et pas .length
			//texteRange.add(texteRange0);
		}

		//list.add(Integer.valueOf(tab[i]));
		//list.add(1, iv); // ajoute la valeur de iv א la place 1

		//2. ranger le texte dans TreeMap sous forme de mots
		//ArrayList<Mot> texteRange = new ArrayList<Mot>();
		Mot mot1 = new Mot("hi");
		texteRange.add(new Mot("salut"));
		texteRange.add(mot1);
		System.out.println(texteRange);

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
