package com.formation.comportement;

import com.formation.emma.inter.Soin;

public class SoinSokaDoliprane implements Soin {

	@Override
	public void soigne() {
		System.out.println("Je prends un Doliprane dès que j'ai mal à la tête");
	}

}
