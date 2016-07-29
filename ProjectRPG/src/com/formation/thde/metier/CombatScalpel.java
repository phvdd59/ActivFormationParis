package com.formation.thde.metier;

import com.formation.thde.inter.EspritCombatif;

public class CombatScalpel implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec un scalpel");
	}
}
