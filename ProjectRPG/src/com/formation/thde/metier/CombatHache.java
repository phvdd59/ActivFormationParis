package com.formation.thde.metier;

import com.formation.thde.inter.EspritCombatif;

public class CombatHache implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Combat avec une peluche de poney");
	}
}