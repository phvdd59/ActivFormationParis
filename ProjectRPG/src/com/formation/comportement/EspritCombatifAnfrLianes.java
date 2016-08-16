package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class EspritCombatifAnfrLianes implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("J'invoque des lianes qui fouettent!");
	}

}
