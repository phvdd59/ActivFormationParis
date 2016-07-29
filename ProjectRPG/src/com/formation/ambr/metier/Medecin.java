package com.formation.ambr.metier;

import com.formation.emma.inter.Soin;
import com.formation.emma.metier.PremierSoin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.made.metier.Marcher;
import com.formation.thde.inter.EspritCombatif;
import com.formation.thde.metier.CombatCouteau;

public class Medecin extends Personnage {

	public Medecin() {
		super();
		this.combat = new CombatCouteau();
		this.soin = new PremierSoin();
		this.deplacement = new Marcher();
	}

	public Medecin(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
		// TODO Auto-generated constructor stub
	}

}
