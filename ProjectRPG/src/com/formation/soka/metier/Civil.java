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
		System.out.println("Prend du doliprane quand il a mal à la tête");
	}

	@Override
	public void deplacer() {
		System.out.println("Il gambade");
	}

	@Override
	public void combat() {
		System.out.println("Il a peur → → →");
	}

}
