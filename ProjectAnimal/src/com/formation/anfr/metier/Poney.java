package com.formation.anfr.metier;

import com.formation.thde.metier.Animal;

public class Poney extends Animal {

	public Poney() {
		super(1000, "rose");
	}
	public Poney(int poids, String couleur) {
		super(poids, couleur);
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
		System.out.println("Le poney poney court court.");
		
	}

	@Override
	public void crier() {
		System.out.println("Le poney hénnit.");
	}
}
