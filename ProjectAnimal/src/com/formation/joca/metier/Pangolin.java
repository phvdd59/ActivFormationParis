package com.formation.joca.metier;

public class Pangolin extends Pholidotes {

	public Pangolin(int poids, String couleur) {
		super(poids, couleur);
	}

	public Pangolin() {
		super();
	}

	public void crier() {
		System.out.println("le pangolin fait le cri du pangolin, si ça existe...");
	}

	public void deplacement() {
		System.out.println("le pangolin se roule en boule et se prend pour Sonic");
	}

	public void manger() {
		System.out.println("le pangolin mange des fourmis et des termites, bon appétit");

	}

	public void boire() {
		System.out.println("le pangolin boit du fanta");

	}

}
