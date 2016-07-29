package com.formation.comportement;

import com.formation.thde.inter.EspritCombatif;

public class EspritCombatifEtgaCombatFusilALunette implements EspritCombatif {

	@Override
	public void combat() {
		System.out.println("Je combats avec mon un fusil de sniper MAUSER SR #GrosCampeur");
	}
}
