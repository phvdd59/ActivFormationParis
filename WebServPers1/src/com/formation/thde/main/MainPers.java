package com.formation.thde.main;

import com.formation.thde.metier.Personne;
import com.formation.thde.metier.PersonneTest;

public class MainPers {

	public static void main(String[] args) {
		MainPers main = new MainPers();
		main.init();

	}

	private void init() {
		PersonneTest persTest = new PersonneTest();
		Personne pers = new Personne();
		System.out.println(persTest.getPersonne("2"));

	}

}
