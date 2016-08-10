package com.formation.thde.main;

import java.util.ArrayList;

import com.formation.thde.metier.Personne;

public class TestListePersonne {

	public static void main(String[] args) {
		//		 * faire un générateur de personnes aléatoires
		//		 * 		- étage de départ
		//		 * 		- étage d'arrivé
		//		 * 		création personne à des temps aléatoires
		//		 *  
		//		 * @param args

		TestListePersonne test = new TestListePersonne();
		test.init();
	}

	public void init() {

		ArrayList<Personne> lst = new ArrayList<Personne>();
		for (int i = 0; i < 20; i++) {
			String nom = "personne " + i;
			int etat = 0;
			int depart = (int) (Math.random() * 20);
			int arrive = (int) (Math.random() * 20);
			while (arrive == depart) {
				arrive = (int) Math.random() * 20;
			}
			lst.add(new Personne(nom, etat, depart, arrive));
		}
		System.out.println(lst);
	}

}
