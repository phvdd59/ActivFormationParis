package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class EspritCombatifPhvaAMort implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Je tue.");
	}
	
}
