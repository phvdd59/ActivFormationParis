package com.formation.etga.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;
import com.formation.thde.exo.Mot;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		texte = texte.toLowerCase();
		texte.replaceAll("[���]", "a");
		texte.replaceAll("[����]", "e");
		texte.replaceAll("[��]", "i");
		texte.replaceAll("[��]", "o");
		texte.replaceAll("[��]", "u");
		texte.replaceAll("  ", " ");

		String[] tabTexte = texte.split("[ ]");

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		return null;
	}

}
