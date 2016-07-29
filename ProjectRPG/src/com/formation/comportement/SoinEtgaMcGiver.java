package com.formation.comportement;

import com.formation.emma.inter.Soin;

public class SoinEtgaMcGiver implements Soin {

	@Override
	public void soigne() {
		System.out.println("Je me soigne tout seul avec mon super kit");

	}

}
