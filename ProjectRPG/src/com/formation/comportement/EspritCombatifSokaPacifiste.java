package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class EspritCombatifSokaPacifiste implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Je m'enfuis quand je peux!!");
	}

}
