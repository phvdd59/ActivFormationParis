package com.formation.jeci.metier;

public class Aigle extends Oiseaux {

	public Aigle() {
		super.setPoids(12);
		super.setCouleur("noir et blanc");

	}
	public Aigle(int poids, String couleur) {
		super(poids, couleur);

	}

	@Override
	public void manger() {
		System.out.println("je suis carnivore et je mange des rongeurs");

	}

	@Override
	public void boire() {
		System.out.println("En soir�e je bois de l'eau mais aussi la journ�e.");

	}

	@Override
	public void deplacement() {
		System.out.println("Je peux marcher sur mes deux pattes ou �galement me d�placer en volant.");

	}

	@Override
	public void crier() {
		System.out.println("Mon cri est per�ant.");

	}
}
