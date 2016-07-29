package com.formation.jeci.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Guerrier extends Personnage {

	public Guerrier() {
		super.combat = null;
		super.deplacement = null;
		super.soin = null;

	}

	public Guerrier(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);

	}

	@Override
	public void seDeplacer() {

		System.out.println("Le guerrier se déplace en marchant et Ce que vous appelez l’enfer, il appelle ça chez lui.");
	}

	@Override
	public void combattre() {

		System.out.println("Force et honneur !,  yooollooo");
	}

	@Override
	public void soigner() {

		System.out.println("un guerrier en soigne pas car c'est un guerrier");
	}

}
