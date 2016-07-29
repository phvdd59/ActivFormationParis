package com.formation.ambr.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	public String epuration(String texte) {

		//1.Hacher le texte sous forme de mots
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[àâ]", "a");
		texte = texte.replaceAll("[éèë]", "e");
		texte = texte.replaceAll("ï", "a");
		texte = texte.replaceAll("[ôö]", "a");
		texte = texte.replaceAll("[ûü]", "a");
		texte = texte.replaceAll("ç", "c");
		texte = texte.replaceAll("\\p{Punct}", "");
		//texte = texte.replaceAll("\\W", "");

		return texte;

	}

	@Override
	public void ranger(String texte) {

		texte = epuration(texte);

		String[] tab = texte.split(" ");

		//Mot mot = new Mot("tous");
		//Mot mot0 = new Mot(tab[0]);

		for (int i = 0; i < tab.length; i++) {
			Mot motI = new Mot(tab[i]);
			for (int j = 0; j < tab[i].length(); j++) {
				String lettre = tab[i].substring(j, j + 1); // j à j+1: il ne prend que j. Si on avait mis j à j+2,  il aurait pris 2 lettres
				CleDico cleDico = new CleDico(lettre, tab[i].length());
				ArrayList<Mot> lst = get(cleDico); // lst sera une liste de valeurs de cleDicos. Les valeurs sont des ArrayLists de mots?
				//compareTo: je regarde la lettre, et ensuite si j'ai regardé la lettre et que ct égal, je compare la longueur
				cleDico.compareTo(cleDico);

			}

		}
	}

	//texteRangeA.add(motI);

	//texteRange0.add(new Mot(get(tab[i]).toString()));
	//texteRange0.add(tab[i]);
	//String.valueOf(tab[i]);

	//		Mot mot1 = new Mot("hi");
	//		texteRange.add(new Mot("salut"));
	//		texteRange.add(mot1);
	//		System.out.println(texteRange);

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
