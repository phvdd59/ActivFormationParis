package com.formation.anfr.metier;

import com.formation.thde.metier.Animal;

public class Equid� extends Animal {

	public Equid�() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equid�(int poids, String couleur) {
		super(poids, couleur);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void manger() {
		System.out.println("Je mange de l'herbe.");

	}



	@Override
	public void boire() {
		System.out.println("J'aspire.");
		

	}

	@Override
	public void deplacement() {
		System.out.println("Je galope!");
	}

	@Override
	public void crier() {
		System.out.println("Je h�nnit.");
	}

}
