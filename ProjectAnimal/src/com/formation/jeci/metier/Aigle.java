package com.formation.jeci.metier;

import com.formation.thde.metier.Animal;

public class Aigle extends Animal {

	public Aigle(int poids, String couleur) {
		super(poids, couleur);

	}

	@Override
	public void manger() {
		System.out.println("je suis carnivore et je mange des rongeurs");

	}

	@Override
	public void boire() {
		System.out.println("En soirée je bois de l'eau mais aussi la journée.");

	}

	@Override
	public void deplacement() {
		System.out.println("Je peux marcher sur mes deux pattes ou également me déplacer en volant.");

	}

	@Override
	public void crier() {
		System.out.println("Mon cri est perçant.");

	}
}
