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
		String testText = "##+☺↨♣Out of the night that covers me, Black as the pit from pole to pole, I thank whatever gods may be For my unconquerable soul. In the fell clutch of circumstance I have not winced nor cried aloud. Under the bludgeonings of chance My head is bloody, but unbowed. Beyond this place of wrath and tears Looms but the Horror of the shade, And yet the menace of the years Finds, and shall find me, unafraid. It matters not how strait the gate, How charged with punishments the scroll, I am the master of my fate: I am the captain of my soul.";
		//String testText = "bbnjour bbnjour comment allez vous.le le le le le le la la li il il il te te te la li li lz";
		dico.ranger(testText);
		//System.out.println(dico.toString());
		ArrayList<String> list = dico.getListeMot("e", 4);
		if (list.isEmpty() == false) {
			System.out.println(list);
		}
	}
}
