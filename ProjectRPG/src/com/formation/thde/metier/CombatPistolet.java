package com.formation.thde.metier;

import com.formation.thde.inter.EspritCombatif;

public class CombatPistolet implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec un fusil de sniper comme un lache");
	}
}
