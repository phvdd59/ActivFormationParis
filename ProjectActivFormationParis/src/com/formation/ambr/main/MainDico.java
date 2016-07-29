package com.formation.ambr.main;

import java.util.ArrayList;

import com.formation.ambr.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();

	}

	public void init() {
		Dico dico = new Dico();
		dico.ranger("Bonjour tout le monde! Comment ça va?");
		ArrayList<String> list = dico.getListeMot("o", 4);
		for (String s : list) { // pour chaque élément de s, il va le mettre dans string
			System.out.println(s + ",");
		}

	}

}
