package com.formation.emma.metier;

import com.formation.thde.metier.Animal;

public class Chien extends Animal {

	public Chien() {
		super(8, "blanc, marron, noir, gris...");
	}

	public Chien(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void manger() {
		System.out.println("J'engloutis");
	}

	@Override
	public void boire() {
		System.out.println("Je lappe");

	}

	@Override
	public void deplacement() {
		System.out.println("Je peux être seul, à deux, à trois... ou en meute");

	}

	@Override
	public void crier() {
		System.out.println("J'aboie");

	}

}
