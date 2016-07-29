package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class ThdeCombatPistolet implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec un fusil de sniper comme un lache");
	}
}
