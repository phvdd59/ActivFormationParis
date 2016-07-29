package com.formation.soka.metier;

import com.formation.thcr.metier.Felin;

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

}
