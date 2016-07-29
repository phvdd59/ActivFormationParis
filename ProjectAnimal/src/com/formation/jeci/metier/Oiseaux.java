package com.formation.jeci.metier;

import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.interfacea.Recueille;
import com.formation.thde.metier.Animal;

public class Oiseaux extends Animal implements Recueille, Ovipare {

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

	@Override
	public void recueille() {
		System.out.println("je recueille");

	}

	@Override
	public void ovipare() {
		System.out.println("je ponds des oeufs");

	}

}
