package com.formation.ambr.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Medecin extends Personnage implements Soin, Deplacement, EspritCombatif {

	public Medecin(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void combat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void soigne() {
		// TODO Auto-generated method stub

	}

}
