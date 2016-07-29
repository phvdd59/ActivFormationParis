package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class ThdePasDeCombat implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Ne combat pas");
	}
}
