package com.formation.made.metier;

import com.formation.thde.metier.Animal;

public class Panda extends Animal {

	public Panda() {
		super.setCouleur("Blanc et noir");
		super.setPoids(800);
	}

	public Panda(int poids, String couleur) {
		super(poids, couleur);

	}

	@Override
	public void manger() {
		System.out.println("je mange du bambou.");

	}

	@Override
	public void boire() {
		System.out.println("je bois de l'eau");

	}

	@Override
	public void deplacement() {
		System.out.println("Je grimpe dans les for�ts de bambous.");

	}

	@Override
	public void crier() {
		System.out.println("Je grogne p�p�rement.");

	}

}
