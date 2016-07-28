package com.formation.made.main;

import com.formation.made.metier.Panda;
import com.formation.thde.metier.Animal;

public class MainAnimal {

	public static void main(String[] args) {
		MainAnimal mainAnimal=new MainAnimal();
		mainAnimal.init();

	}

	private void init() {
		Animal panda=new Panda(800,"");
		System.out.println(panda.getCouleur());
	}

}
