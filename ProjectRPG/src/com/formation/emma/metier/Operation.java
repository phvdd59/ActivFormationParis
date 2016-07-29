package com.formation.emma.metier;

import com.formation.emma.inter.Soin;

public class Operation implements Soin{

	@Override
	public void soigne() {
		System.out.println("Attention gros bobo, opération obligatoire");
		
	}

}
