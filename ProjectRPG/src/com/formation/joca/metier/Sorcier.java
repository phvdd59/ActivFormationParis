package com.formation.joca.metier;

import com.formation.emma.inter.Soin;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Sorcier extends Personnage {

	public Sorcier(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
	}

	public Sorcier() {
		this.combat = new EspritCombatifMage();
		this.deplacement = new DeplacementJocaTeleport();
		this.soin = new SoinJocaMana();
	}

}
