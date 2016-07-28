package com.formation.phva.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		// TODO Auto-generated method stub
		
		texte=texte.toLowerCase();
		texte=texte.replace('é', 'e');
		texte=texte.replace('-',' ');
		texte = "Une intelligence artificielle écrit le scénario d’un court-métrage";
		texte = texte.toLowerCase();
		texte = texte.replace('é', 'e');
		texte = texte.replace('-', ' ');
		texte=texte.replace('’', ' ');
		System.out.println(texte);
	
		String[]tabmot=texte.split(" ");
		for (int i = 0; i < tabmot.length; i++) {
			System.out.println(tabmot[i]);
		}
		ArrayList<String>listString = new ArrayList<String>();
		for (int i = 0; i < tabmot.length; i++) {
			listString.add(i, tabmot[i]);
		}
		System.out.println(listString);
		ArrayList<Mot>motlist=new ArrayList<Mot>();
		for (int i = 0; i < motlist.size(); i++) {
			Mot motAjouter = new Mot(listString.get(i));
			motlist.add(motAjouter);
		}
	
		

	}
		

		
	


	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
