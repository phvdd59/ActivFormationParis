package com.formation.thde.metier;

import com.formation.thde.inter.EspritCombatif;

public class PasDeCombat implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Ne combat pas");
	}
}
