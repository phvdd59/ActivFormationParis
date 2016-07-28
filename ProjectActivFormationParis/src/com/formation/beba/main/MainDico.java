package com.formation.beba.main;

import com.formation.beba.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();

	}

	public void init() {
		Dico dico = new Dico();
		String text = ("le dormeur doit se doit lever puis voila et doit encore se coucher");
		dico.ranger(text);
		System.out.println(dico.getListeMot("o", 4));

	}

}
