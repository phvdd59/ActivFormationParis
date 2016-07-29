package com.formation.issa.metier;

import com.formation.joca.metier.Canin;
import com.formation.thde.metier.Animal;

public class Loup extends Canin  {
	

	public Loup() {
		super(80,"noir");
		
	}
	

	public Loup(int poids, String couleur) {
		super(poids, couleur);
	}


	@Override
	public void manger() {
		System.out.println("Je dévore");
	

	}

	@Override
	public void boire() {
		System.out.println("Je lape");

	}

	@Override
	public void crier() {
		System.out.println("Je hurle");
		System.out.println("Je grogne");

	}


	@Override
	public boolean egale(Animal animal) {
		// TODO Auto-generated method stub
		boolean result=false;
		if(animal instanceof Loup ){
			if((this.getCouleur().equals(animal.getCouleur()))&& (this.getPoids()==(animal.getPoids())));
			return true;
		}
		return result;
	}

}
