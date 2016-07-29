package com.formation.thde.main;

import java.util.ArrayList;

import com.formation.thde.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico m = new MainDico();
		m.init();

	}

	public void init() {
		Dico dico = new Dico();
		String testText = "Out of the night that covers me, Black as the pit from pole to pole, I thank whatever gods may be For my unconquerable soul. In the fell clutch of circumstance I have not winced nor cried aloud. Under the bludgeonings of chance My head is bloody, but unbowed. Beyond this place of wrath and tears Looms but the Horror of the shade, And yet the menace of the years Finds, and shall find me, unafraid. It matters not how strait the gate, How charged with punishments the scroll, I am the master of my fate: I am the captain of my soul.";
		dico.ranger(testText);
		for (int i = 1; i < 10; i++) {
		ArrayList<String> list = dico.getListeMot("e", i);
		System.out.println("mots de " +i+" lettres : " + list);
	}
	}
}
