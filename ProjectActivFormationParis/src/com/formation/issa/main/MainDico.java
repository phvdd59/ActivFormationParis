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
		String texteEpurer = new String();
		texteEpurer = "Une intelligence artificielle écrit le scénario d’un court-métrage";
		 dico.ranger(texteEpurer);
		dico.getListeMot("i", 4);
		System.out.println(dico.epuration(texteEpurer));
		ArrayList<Mot> listing = new ArrayList<Mot>();

		// ArrayList<String>listmot = new ArrayList<String>();
		// listmot = dico.getListeMot("o", 4);
		// System.out.println(listmot);
		// for (String s : listmot) {
		// System.out.println(s +",");
		// }

		CleDico cleDico = new CleDico(texteEpurer, 3);

	}

}