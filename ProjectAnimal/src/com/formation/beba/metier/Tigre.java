package com.formation.beba.metier;

import com.formation.thcr.metier.Felin;
import com.formation.thde.metier.Animal;

public class Tigre extends Felin {

	public Tigre() {
		super(300, "Classe");
		// TODO Auto-generated constructor stub
	}

	public Tigre(int poids, String couleur) {
		super(poids, couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manger() {
		System.out.println("Court petit herbivore!");

	}

	@Override
	public void boire() {
		System.out.println("Slurp, slurp");

	}

	@Override
	public void deplacement() {
		System.out.println("Patoune, patoune");

	}

	@Override
	public void crier() {
		System.out.println("Graou");

	}

	@Override
	public void lapper() {
		System.out.println("Je Lappe tout seul ! he toc !!!");
	}

	@Override
	public boolean egale(Animal animal) {
		boolean result = false;
		if(animal instanceof Tigre){
			if (this.getCouleur().equals(animal.getCouleur()) && (this.getPoids()==animal.getPoids())){
				result = true;
			}
		}
		return result;
	}

}
