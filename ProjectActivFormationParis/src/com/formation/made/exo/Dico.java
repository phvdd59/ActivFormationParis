package com.formation.made.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import org.hamcrest.core.SubstringMatcher;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		String TexteAEpurer = epuration(texte); // on utilise la méthode epurer pour epurer le texte
		String[] tabStringTexte = TexteAEpurer.split(" "); //on split 

		//for (int i = 0; i < tabStringTexte.length; i++) {
			// System.out.println(tabStringTexte[i]);
		//}
		
		for (int i = 0; i < tabStringTexte.length; i++) {
			Mot mot=new Mot(tabStringTexte[i]);
			for (int j = 0; j < tabStringTexte[i].length(); j++) {
				String lettre=tabStringTexte[i].substring(j, j+1);
				CleDico cleDico=new CleDico(lettre, tabStringTexte[i].length());
				ArrayList<Mot> lst=get(cleDico); 
				if (lst.contains(mot)) {
					mot.plusUn();		
				}
				else{
					lst.add(mot);
				}
			}for (int j = 0; j < tabStringTexte.length; j++) {
				
			}
			System.out.println();
		}
	}

	public String epuration(String texte) {
		String texteepure = new String();
		String texteSansMaj = texte.toLowerCase(); // on met le texte en minuscule
		String[] caracspeciaux = { "!", "?", ".", "'", "  " }; // creer le tableau de la ponctuation pour le remplacer
		for (String string : caracspeciaux) {
			texte = texteSansMaj.replace(string, " ");
			texteSansMaj = texte;
		}
		texte = texte.replace("é", "e");
		texte = texte.replace("è", "e");
		texte = texte.replace("ê", "e");
		texte = texte.replace("à", "a");
		texte = texte.replace("â", "a");
		texte = texte.replace("ù", "u");
		texte = texte.replace("ô", "o");
		texteepure = texte;
		return texteepure;
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
