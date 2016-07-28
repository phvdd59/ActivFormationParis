package com.formation.thde.main;

import com.formation.anfr.metier.Poney;

public class MainAnimal {
	public static void main(String[] args) {

		MainAnimal mainAnimal = new MainAnimal();
		mainAnimal.init();
	}

	public void init() {
		Poney nouvelAnimal = new Poney(100, "vert");
		System.out.println(nouvelAnimal.getCouleur() + "   " + nouvelAnimal.getPoids());
	}

}
