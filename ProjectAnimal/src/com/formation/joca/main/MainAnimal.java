package com.formation.joca.main;

import com.formation.joca.metier.Pangolin;

public class MainAnimal {

	public static void main(String[] args) {
			Pangolin pango = new Pangolin();
			pango.deplacement();
			pango.boire();
			pango.manger();
			pango.crier();
	}

}
