package com.formation.jeci.comporetement;

import com.formation.made.inter.Deplacement;

public class DeplacementJeCi implements Deplacement{

	@Override
	public void deplacer() {
		System.out.println("Je me déplace tout seul car je suis solide");
		
	}

}
