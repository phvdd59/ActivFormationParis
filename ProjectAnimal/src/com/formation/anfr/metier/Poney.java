package com.formation.anfr.metier;

public class Poney extends Equid� {

	public Poney() {
		super(1000, "rose");
	}
	public Poney(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void deplacement() {
		super.deplacement();
		System.out.println("Le poney poney court court.");
		
	}

}
