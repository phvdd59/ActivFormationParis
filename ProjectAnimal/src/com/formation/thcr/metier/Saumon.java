package com.formation.thcr.metier;

import com.formation.jeci.interfacea.Ovipare;
import com.formation.thde.metier.Animal;

public class Saumon extends Animal implements Ovipare {

	public Saumon() {
		super(3, "vert fluo");
	}

	public Saumon(int poids, String str) {
		super(poids, str);
	}

	@Override
	public void manger() {
		System.out.println("Je mange d'autres poissons");
	}

	@Override
	public void boire() {
		System.out.println("Je ne bois pas");
	}

	@Override
	public void deplacement() {
		System.out.println("Je nage");
	}

	@Override
	public void crier() {
		System.out.println("Dans l'eau, personne ne vous entendra crier !!!");
	}

	@Override
	public void pondre() {
		System.out.println("Je pond des œufs");

	}

	@Override
	public void eclore() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean egale(Animal animal) {
		boolean result = false;
		if (animal instanceof Saumon) {
			if (this.getCouleur().equals(animal.getCouleur())
					&& this.getPoids() == animal.getPoids()) {
				result = true;
			}
		}
		return result;
	}

}
