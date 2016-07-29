package com.formation.comportement;

import com.formation.emma.inter.Soin;

public class SoinAmbrMedSoin implements Soin {

	@Override
	public void soigne() {
		System.out.println("Je diagnostique et prodigue des soins en conséquence");
	}

}
