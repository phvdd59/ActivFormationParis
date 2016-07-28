package com.formation.ambr.metier;

import com.formation.jeci.metier.Oiseaux;

public class Corneille extends Oiseaux {

	public Corneille() {
		super(1, "noir");
	}

	public Corneille(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void manger() {
		System.out.println("Je picore");
	}

	@Override
	public void boire() {
		System.out.println("Je coule");
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
