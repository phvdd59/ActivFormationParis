package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class ThdeCombatHache implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec une hache en plastique");
	}
}
