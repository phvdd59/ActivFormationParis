package com.formation.joca.metier;

import com.formation.emma.inter.Soin;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public abstract class Personnage {

	public EspritCombatif combat;
	public Deplacement deplacement;
	public Soin soin;

	public Personnage(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super();
		this.combat = combat;
		this.deplacement = deplacement;
		this.soin = soin;
	}

	public Personnage() {
	}

	public void seDeplacer() {
		deplacement.deplacer();
	}

	public void combattre() {
		combat.combat();
	}

	public void soigner() {
		soin.soigne();
	}

}
