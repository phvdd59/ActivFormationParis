package com.formation.thcr.metier;

import com.formation.thde.metier.Animal;

public class Poisson extends Animal {

	public Poisson() {
		super(3, "vert fluo");
	}

	public Poisson(int poids, String str) {
		super(poids, str);
	}

	@Override
	public void manger() {
		System.out.println("Je mange d'autres poissons");

	}

	@Override
	public void boire() {
		System.out.println("Je ne bois pas");

	}

	@Override
	public void deplacement() {
		System.out.println("Je nage");

	}

	@Override
	public void crier() {
		System.out.println("Dans l'eau, personne ne vous entendra crier !!!");

	}

}
