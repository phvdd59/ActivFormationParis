package com.formation.joca.metier;

public class Pangolin extends com.formation.thde.metier.Animal {

	public Pangolin(int poids, String couleur) {
		super(poids, couleur);
	}

	public void crier() {
		System.out.println("le pangolin fait le cri du pangolin...");
	}

	public void deplacement() {
		System.out.println("le pangolin se roule en boule et se prend pour Sonic");
	}

	public void manger() {
		System.out.println("le pangolin mange des fourmis et des termites, bon appétit");

	}

	public void boire() {
		System.out.println("le pangolin boit du fanta"+"\u00a9"+", sa boisson préférée");

	}

}
