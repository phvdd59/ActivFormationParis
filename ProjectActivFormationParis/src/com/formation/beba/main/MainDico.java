package com.formation.beba.main;

import com.formation.beba.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();

	}

	public void init() {
		Dico dico = new Dico();
		String text = ("bbnjour bbnjour comment allez vous.le le le le le le la la li il il il te te te la li li lz");
		dico.ranger(text);
		System.out.println(dico.toString());

	}

}
