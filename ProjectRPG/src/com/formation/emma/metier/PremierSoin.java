package com.formation.emma.metier;

import com.formation.emma.inter.Soin;

public class PremierSoin implements Soin {

	@Override
	public void soigne() {
		System.out.println("Un petit pansement et tout ira bien");
		
	}

}
