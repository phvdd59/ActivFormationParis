package com.formation.etga.metier;

import com.formation.emma.inter.Soin;
import com.formation.emma.metier.PremierSoin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.made.metier.NeBougePas;
import com.formation.thde.inter.EspritCombatif;
import com.formation.thde.metier.CombatPistolet;

public class Sniper extends Personnage {

	public Sniper() {
		super();
		this.combat = new CombatPistolet();
		this.deplacement = new NeBougePas();
		this.soin = new PremierSoin();
	}

	public Sniper(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		this.combat = combat;
		this.deplacement = deplacement;
		this.soin = soin;

	}

	public void soigner() {
		System.out.println("Je me soigne tout seul avec mon super kit si c'est pas trop grave");
	}

	public void seDeplacer() {
		System.out.println("Pas trop trop");
	}

	public void combattre() {
		System.out.println("Je combats avec mon snip aaiiiiggght #GrosCampeur");
	}
}
