package com.formation.emma.metier;

import com.formation.emma.inter.Soin;

public class NeSoignePAs implements Soin {

	@Override
	public void soigne() {
		System.out.println("Pas besoin de soin, même pas mal !");
		
	}

}
