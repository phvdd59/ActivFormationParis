package com.formation.emma.exo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[��]", "a");
		texte = texte.replaceAll("[����]", "e");
		texte = texte.replaceAll("�", "u");
		texte = texte.replaceAll("�", "c");
		texte = texte.replaceAll("�", "o");
		texte = texte.replaceAll("[��]", "i");
		texte = texte.replaceAll("\\p{Punct}", "");
		String[] tab = texte.split(" ");

		ArrayList<String> listeDeMots = new ArrayList<String>();

		for (int i = 0; i < tab.length; i++) {
			listeDeMots.add(tab[i]);
		}

		
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
