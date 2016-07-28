package com.formation.anfr.metier;

import com.formation.thde.metier.Animal;

public class Poney extends Animal {

	public Poney(int poids, String couleur) {
		super(1000, "rose");
	}

	@Override
	public void manger() {
		System.out.println("Le poney mange de l'herbe.");
		
	}

	@Override
	public void boire() {
		System.out.println("Le poney boit avec la langue.");
		
	}

	@Override
	public void deplacement() {
		System.out.println("Le poney galope.");
		
	}

	@Override
	public void crier() {
		System.out.println("Le poney hénnit.");
	}
}
