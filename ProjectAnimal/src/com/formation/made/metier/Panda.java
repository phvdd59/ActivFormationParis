package com.formation.made.metier;

import com.formation.thde.metier.Animal;

public class Panda extends Animal {

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
		System.out.println("Je grimpe dans les forêts de bambous.");

	}

	@Override
	public void crier() {
		System.out.println("Je grogne pépèrement.");

	}

}
