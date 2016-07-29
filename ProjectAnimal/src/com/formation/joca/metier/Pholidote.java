package com.formation.joca.metier;

import com.formation.etga.Interface.Lapper;
import com.formation.thde.metier.Animal;

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
		System.out.println("la famille des pholidotes se déplace sur leurs quatres pattes");
	}

	@Override
	public void crier() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean egale(Animal animal) {
		boolean result = false;
		if (animal instanceof Pholidote) {
			if (this.getPoids() == animal.getPoids() && this.getCouleur().equals(animal.getCouleur())) {
				result = true;
			}
		}
		return result;
	}

}
