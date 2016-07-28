package com.formation.jeci.metier;

import com.formation.thde.metier.Animal;

public class Oiseaux extends Animal {

	public Oiseaux() {
		super.setPoids(2);
		super.setCouleur("noir et blanc");

	}

	public Oiseaux(int poids, String couleur) {
		super(poids, couleur);

	}

	@Override
	public void manger() {

	}

	@Override
	public void boire() {

	}

	@Override
	public void deplacement() {

	}

	@Override
	public void crier() {

	}

}
