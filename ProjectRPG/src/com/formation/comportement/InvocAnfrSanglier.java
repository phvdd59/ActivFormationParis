package com.formation.comportement;

import com.formation.anfr.metier.Invocation;

public class InvocAnfrSanglier implements Invocation {

	@Override
	public void invoker() {
		System.out.println("J'invoque un sanglier geant!");

	}

}
