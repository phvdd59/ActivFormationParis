package com.formation.anfr.main;

import com.formation.beba.metier.Tigre;
import com.formation.jeci.metier.Aigle;
import com.formation.joca.metier.Pangolin;
import com.formation.made.metier.Panda;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;

public class MainAnimal {

	public static void main(String[] args) {
		MainAnimal mainAnimal = new MainAnimal();
		mainAnimal.init();

	}

	private void init() {
		Saumon poisson = new Saumon();
		poisson.deplacement();
		poisson.crier();
		poisson.boire();
		poisson.manger();
		
		Tigre tigre = new Tigre();
		tigre.deplacement();
		tigre.crier();
		tigre.boire();
		tigre.manger();
		
		Aigle aigle = new Aigle(25,"Maron");
		aigle.deplacement();
		aigle.boire();
		aigle.crier();
		aigle.manger();
		
		Pangolin pango = new Pangolin(25,"Marron");
		pango.deplacement();
		pango.boire();
		pango.crier();
		pango.manger();
		
		Lion lion = new Lion();
		lion.deplacement();
		lion.boire();
		lion.manger();
		lion.crier();
		
		Panda panda = new Panda();
		panda.deplacement();
		panda.boire();
		panda.manger();
		panda.crier();
		
//		Corneille corn = new Corneille();
//		corn.boire();
//		corn.manger();
//		corn.crier();
//		corn.deplacement();
	}
	
}
