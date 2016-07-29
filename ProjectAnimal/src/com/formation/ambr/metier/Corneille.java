package com.formation.ambr.metier;

import com.formation.jeci.metier.Oiseaux;
import com.formation.thde.metier.Animal;

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
		System.out.println("Je recueille");
	}

	@Override
	public void deplacement() {
		System.out.println("Je marche ou je vole");
	}

	@Override
	public void crier() {
		System.out.println("Je croasse");
	}

	@Override
	public boolean egale(Animal animal) {
		boolean result = false;
		if (animal instanceof Corneille) {
			if (this.getCouleur().equals(animal.getCouleur()) && this.getPoids() == animal.getPoids()) {
				result = true;
			}

		}
		return result;
	}

}
