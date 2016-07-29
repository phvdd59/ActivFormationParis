package com.formation.made.metier;

public class Panda extends Ursides {

	public Panda() {
		super(800, "Blanc et noir");
	}

	public Panda(int poids, String couleur) {
		super(poids, couleur);

	}

	@Override
	public void manger() {
		System.out.println("le panda mange du bambou.");

	}

	@Override
	public void boire() {
		System.out.println("Le panda lappe");

	}

	@Override
	public void deplacement() {
		System.out.println("le panda grimpe dans les forêts de bambous.");

	}

	@Override
	public void crier() {
		System.out.println("Je grogne pépèrement.");

	}
	
	

}
