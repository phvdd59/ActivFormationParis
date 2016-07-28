package com.formation.joca.metier;

import com.formation.thde.metier.Animal;

public abstract class Canin extends Animal {

	public Canin(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void deplacement() {
		System.out.println("la famille des canins se déplace sur leurs quatres pattes");
	}

}
