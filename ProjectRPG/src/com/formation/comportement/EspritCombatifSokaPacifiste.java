package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class EspritCombatifSokaPacifiste implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Pas la guerre, pas la guerre, pas la guerre!!!");
	}

}
