package com.formation.beba.metier;

import com.formation.thde.metier.Animal;

public class Tigre extends Animal {

	public Tigre() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manger() {
		System.out.println("Court petit herbivore!");

	}

	@Override
	public void boire() {
		System.out.println("Slurp, slurp");

	}

	@Override
	public void deplacement() {
		System.out.println("Patoune, patoune");

	}

	@Override
	public void crier() {
		System.out.println("Graou");

	}

}
