package com.formation.jeci.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Guerrier extends Personnage {

	public Guerrier(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);

	}

	@Override
	public void seDeplacer() {

		super.seDeplacer();
	}

	@Override
	public void combattre() {

		super.combattre();
	}

	@Override
	public void soigner() {

		super.soigner();
	}

}
