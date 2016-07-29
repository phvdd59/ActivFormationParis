package com.formation.thde.metier;

import com.formation.thde.inter.EspritCombatif;

public class CombatPistolet implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec une arme à feu");
	}
}
