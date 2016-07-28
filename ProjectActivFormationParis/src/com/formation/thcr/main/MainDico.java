package com.formation.thcr.main;

import com.formation.thcr.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico main = new MainDico();
		main.init();

	}

	private void init() {
		String s = "Bonjour, je suis un texte test. Bonjour, je met des mots qui apparaissent plusieurs fois.\nBonjour, je réitère.";
		Dico dico = new Dico();
		
		System.out.println(s);
		dico.ranger(s);
		
	}

}
