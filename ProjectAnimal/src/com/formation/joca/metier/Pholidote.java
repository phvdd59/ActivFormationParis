package com.formation.joca.metier;

import com.formation.etga.Interface.Lapper;

public class Pholidote extends com.formation.thde.metier.Animal implements Lapper {

	public Pholidote() {
		super();
	}

	public Pholidote(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void lapper() {
		System.out.println("la famille des Pholidotes boit en lappant");
	}

	@Override
	public void manger() {
		// TODO Auto-generated method stub

	}

	@Override
	public void boire() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deplacement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void crier() {
		// TODO Auto-generated method stub

	}

}
