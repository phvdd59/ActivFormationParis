package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class ThdeCombatCouteau implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec un couteau");
	}
}
