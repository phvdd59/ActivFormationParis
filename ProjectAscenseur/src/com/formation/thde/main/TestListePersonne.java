package com.formation.thde.main;

import java.util.ArrayList;

import com.formation.thde.metier.Personne;

public class TestListePersonne {

	public static void main(String[] args) {
		//		 * faire un g�n�rateur de personnes al�atoires
		//		 * 		- �tage de d�part
		//		 * 		- �tage d'arriv�
		//		 * 		cr�ation personne � des temps al�atoires
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
