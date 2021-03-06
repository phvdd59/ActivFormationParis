package com.formation.soka.metier;

import com.formation.thcr.metier.Felin;
import com.formation.thde.metier.Animal;

public class Lion extends Felin {

	public Lion() {
		super(180, "rouge");

	}

	public Lion(int poids, String str) {
		super(poids, str);
	}

	@Override
	public void manger() {
		System.out.println("Je mange tous les animaux de la Jungle");
	}

	@Override
	public void boire() {
		System.out.println("Je lape, je bois");
	}

	@Override
	public void deplacement() {
		System.out.println("Je me d�place pour mieux digerer");
	}

	@Override
	public void crier() {
		System.out.println("Je rugis apr�s avoir bien mang�");
	}

	@Override
	public void lapper() {
		System.out.println("Le lion lappe");
	}

	@Override
	public void gestation() {
		System.out.println("Le lion est vivipare");
	}

	@Override
	public boolean egale(Animal animal) {
		boolean b = false;
		if (animal instanceof Lion) {
			if (this.getCouleur().equals(animal.getCouleur()) && (this.getPoids() == animal.getPoids())) {
				b = true;
			}
		}
		return b;
	}

}
