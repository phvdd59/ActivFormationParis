package com.formation.joca.metier;

import com.formation.made.inter.Deplacement;

public class DeplacementJocaTeleport implements Deplacement {

	@Override
	public void deplacer() {
		System.out.println("je me teleporte");
	}

}
