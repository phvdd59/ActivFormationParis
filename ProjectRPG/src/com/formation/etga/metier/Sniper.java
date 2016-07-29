package com.formation.etga.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Sniper extends Personnage {

	public Sniper() {
		super();
	}

	public Sniper(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		this.combat = combat;
		this.deplacement = deplacement;
		this.soin = soin;

	}

	@Override
	public void combattre() {
		System.out.println("Je combats avec mon snip aaiiiiggght #GrosCampeur");

	}

	@Override
	public void seDeplacer() {
		System.out.println("Pas trop trop");
	}

	@Override
	public void soigner() {
		System.out.println("Je me soigne tout seul avec mon super kit si c'est pas trop grave");
	}
}
