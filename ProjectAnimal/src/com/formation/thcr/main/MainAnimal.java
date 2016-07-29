package com.formation.thcr.main;

import com.formation.ambr.metier.Corneille;
import com.formation.beba.metier.Tigre;
import com.formation.jeci.metier.Aigle;
import com.formation.made.metier.Panda;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;
import com.formation.thde.metier.Animal;

public class MainAnimal {
	public static void main(String[] args) {
		MainAnimal main = new MainAnimal();
		main.init();

	}

	private void init() {
		Animal a = new Saumon();
		a.boire();
		a.crier();
		a.deplacement();
		a.manger();
		
		Animal b = new Lion();
		b.boire();
		b.crier();
		b.deplacement();
		b.manger();
		
		Animal c = new Corneille();
		c.boire();
		c.crier();
		c.deplacement();
		c.manger();
		
		Animal d = new Panda();
		d.boire();
		d.crier();
		d.deplacement();
		d.manger();
		
		Animal e = new Aigle();
		e.boire();
		e.crier();
		e.deplacement();
		e.manger();
		
		Animal f = new Tigre();
		f.boire();
		f.crier();
		f.deplacement();
		f.manger();
		
		
		
	}
}
