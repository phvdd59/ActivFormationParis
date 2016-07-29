package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class EspritCombatifAmbrMedCur implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("J'injecte une solution de curare");
	}

}
