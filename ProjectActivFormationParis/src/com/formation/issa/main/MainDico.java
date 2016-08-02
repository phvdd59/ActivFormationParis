package com.formation.issa.main;

import java.util.ArrayList;

import com.formation.issa.exo.CleDico;
import com.formation.issa.exo.Dico;
import com.formation.issa.exo.Mot;

public class MainDico {

	public MainDico() {

	}

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();

	}

	public void init() {
		Dico dico = new Dico();
		String texte = new String();
		texte = "Une intelligence artificielle écrit le scénario d’un court-métrage";
		// dico.ranger(texte);
		dico.getListeMot("i", 4);
		System.out.println(texte);
		ArrayList<Mot> listing = new ArrayList<Mot>();

		// ArrayList<String>listmot = new ArrayList<String>();
		// listmot = dico.getListeMot("o", 4);
		// System.out.println(listmot);
		// for (String s : listmot) {
		// System.out.println(s +",");
		// }

		CleDico cleDico = new CleDico(texte, 3);

	}

}