package com.formation.etga.metier;

import com.formation.etga.Interface.Lapper;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.thde.metier.Animal;

public class Serpent extends Animal implements Lapper, Ovipare {

	public Serpent(int poids, String couleur) {
		super(poids, couleur);
	}

	public Serpent() {
		super(2, "noir à collier rouge");
	}

	public void crier() {
		System.out.println("Tsssss");
	}

	public void deplacement() {
		System.out.println("Le serpent rampe");
	}

	public void manger() {
		System.out.println("le serpent mange des insectes et les mollets des gens");

	}

	public void boire() {
		System.out.println("le serpent boit ce qu'il trouve");

	}

	@Override
	public void lapper() {
		System.out.println("On va dire qu'un serpent lappe quand il crève de soif");
	}

	@Override
	public void pondre() {
		System.out.println("Quand je ponds je suis content");

	}

	@Override
	public void eclore() {
		System.out.println("Oh, oh, oh ..... un Abo a été ajouté à votre pokédex ");

	}
	
	@Override
	public boolean egale (Animal animal) {
		boolean result = false;
		if (animal instanceof Serpent) {
			if ((this.getCouleur().equals(animal.getCouleur()) &&(this.getPoids() == animal.getPoids()))) {
				result = true;
			}
		}
		return result;
	}
}
