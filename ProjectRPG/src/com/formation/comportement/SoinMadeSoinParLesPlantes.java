package com.formation.comportement;

import com.formation.emma.inter.Soin;

public class SoinMadeSoinParLesPlantes implements Soin {

	@Override
	public void soigne() {
		System.out.println("Je me soigne en fumant des herbes");

	}

}
