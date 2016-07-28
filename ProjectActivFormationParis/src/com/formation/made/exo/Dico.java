package com.formation.made.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		ArrayList<String> listeDeString = new ArrayList<>();
		String textecopie=new String();
		textecopie=texte;
		String texteSansMaj = texte.toLowerCase(); //on met le texte en minuscule
		String[] caracspeciaux = { "!", "?", ".", "'", "  " }; //creer le tableau de la ponctuation pour le remplacer
		for (String string : caracspeciaux) {
			textecopie = texteSansMaj.replace(string, " ");
			texteSansMaj = texte;
		}
		textecopie = texte.replace("é", "e");
		textecopie = texte.replace("è", "e");
		textecopie = texte.replace("ê", "e");
		textecopie = texte.replace("à", "a");
		textecopie = texte.replace("â", "a");
		textecopie = texte.replace("ù", "u");
		textecopie = texte.replace("ô", "o");
		String[] tabStringTexte = textecopie.split(" ");
		for (int i = 0; i < tabStringTexte.length; i++) {
			//System.out.println(tabStringTexte[i]);
		}
		for (int i = 0; i < tabStringTexte.length; i++) {
			listeDeString.add(tabStringTexte[i]);
			
		}
		System.out.println(listeDeString);
		ArrayList<Mot> listeDeMots=new ArrayList<Mot>();
		for (String string : listeDeString) {
			Mot mot=new Mot(string);
			if (listeDeMots.contains(mot)) {
				mot.plusUn();
			}
			listeDeMots.add(mot);
		}

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
