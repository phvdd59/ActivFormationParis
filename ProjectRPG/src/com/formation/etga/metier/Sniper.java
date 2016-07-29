package com.formation.etga.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Sniper extends Personnage {

	public Sniper() {
		super();
		this.combat = new EspritCombatifEtgaCombatFusilALunette();
		this.deplacement = new DeplacementEtgaFurtif();
		this.soin = new SoinEtgaMcGiver();
	}

	public Sniper(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		this.combat = combat;
		this.deplacement = deplacement;
		this.soin = soin;
	}
}
