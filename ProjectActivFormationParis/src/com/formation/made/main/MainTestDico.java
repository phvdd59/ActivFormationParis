package com.formation.made.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.made.exo.CleDico;
import com.formation.made.exo.Dico;
import com.formation.made.exo.Mot;

public class MainTestDico {

	public static void main(String[] args) {
		MainTestDico mainTestDico = new MainTestDico();
		mainTestDico.init();

	}

	private void init() {
		String g = "Bonjourné tout! le monde. Il fé chaud! aujourd'huièé.é ?";
		System.out.println(g.toLowerCase());

		System.out.println(g.replace("'", " "));
		System.out.println(g.replace("é", "e"));
		String[] caracspeciaux = { "!", "?", ".", "'", "  " };
		for (String string : caracspeciaux) {
			String k = (g.replace(string, " "));
			g = k;
		}
		System.out.println((g.replace("é", "e")));

		Dico dico = new Dico();
		// dico.ranger("élo it's môuà.??bébé fenêtre!. ");
		CleDico cledico = new CleDico("u", 5);
		ArrayList<CleDico> listCleDico = new ArrayList<CleDico>();
		TreeMap<CleDico, ArrayList<Mot>> map = new TreeMap<CleDico, ArrayList<Mot>>();
		ArrayList<Mot> lst = map.get(cledico);
		Mot mot = new Mot("Jesuisunmot");
		String string="^ù$éméà@çâêîôËñ,?;";
		System.out.println(dico.epuration(string));

		// Dico dico2 = new Dico();
		// dico2.ranger("élo it's pôlà. ? bébé fenêtre! . bébé est est est");
	}

}
