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
		dico.ranger("Bonjour bonjour bonjour tout le monde");
		ArrayList<String> list = dico.getListeMot("o", 4);
		System.out.println(list);
		//		for (String s : list) {
		//			System.out.println(s + ", ");
		//		}
	}

}
