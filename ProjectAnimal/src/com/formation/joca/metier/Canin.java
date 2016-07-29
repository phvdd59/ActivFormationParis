package com.formation.joca.metier;

import com.formation.etga.Interface.lapper;
import com.formation.thde.metier.Animal;

public abstract class Canin extends Animal implements lapper {

	public Canin(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void deplacement() {
		System.out.println("la famille des canins se déplace sur leurs quatres pattes");
	}

	@Override
	public void lapper() {
		System.out.println("la famille des canins boit en lappant");
	}

}
