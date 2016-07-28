package com.formation.ambr.metier;

import com.formation.thde.metier.Animal;

public class Corneille extends Animal {

	public Corneille(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void manger() {
		System.out.println("Je picore");
	}

	@Override
	public void boire() {
		System.out.println("J'utilise mon bec comme récipient");
	}

	@Override
	public void deplacement() {
		System.out.println("Je marche ou je vole");
	}

	@Override
	public void crier() {
		System.out.println("Je croasse");
	}

}
