package com.formation.comportement;

import com.formation.made.inter.Deplacement;

public class DeplacementThcrRampe implements Deplacement {

	@Override
	public void deplacer() {
		System.out.println("Je rampe par terre dans la boue");
	}

}
