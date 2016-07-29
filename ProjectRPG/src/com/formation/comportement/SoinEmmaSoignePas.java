package com.formation.comportement;

import com.formation.emma.inter.Soin;

public class SoinEmmaSoignePas implements Soin {

	@Override
	public void soigne() {
		System.out.println("Pas besoin de soin, même pas mal !");
		
	}

}
