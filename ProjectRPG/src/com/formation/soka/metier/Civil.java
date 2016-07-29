package com.formation.soka.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Civil extends Personnage implements EspritCombatif, Deplacement, Soin {

	public Civil() {

	}

	public Civil(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
	}

	@Override
	public void soigne() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void combat() {
		// TODO Auto-generated method stub

	}

}
