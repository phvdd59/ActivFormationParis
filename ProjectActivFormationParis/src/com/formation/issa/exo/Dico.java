package com.formation.issa.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.CleDico;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		// TODO Auto-generated method stub
		System.out.println(texte);
		texte = epuration(texte);
		String[] tabmot = texte.split(" ");

		for (int i = 0; i < tabmot.length; i++) {
			String motTexte = tabmot[i];
			for (int j = 0; j < motTexte.length(); j++) {
				String lettre = motTexte.substring(j, j + 1);
				CleDico cleDico = new CleDico(lettre, motTexte.length());
				ArrayList<Mot> listing=get(cleDico);
			   
			}
		}

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null ;
	}

	public String epuration(String texteAepurer) {

		String texteEpurer = texteAepurer;
		texteEpurer = texteEpurer.toLowerCase();
		texteEpurer = texteEpurer.replace('é', 'e');
		texteEpurer = texteEpurer.replace('-', ' ');
		texteEpurer = texteEpurer.toLowerCase();
		texteEpurer = texteEpurer.replace('é', 'e');
		texteEpurer = texteEpurer.replace('-', ' ');
		texteEpurer = texteEpurer.replace('’', ' ');

		return texteEpurer;
	}

}
