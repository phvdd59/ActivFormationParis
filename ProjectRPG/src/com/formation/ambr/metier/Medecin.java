package com.formation.ambr.metier;

import com.formation.comportement.DeplacementAmbrMedBio;
import com.formation.comportement.EspritCombatifAmbrMedCur;
import com.formation.comportement.SoinEmmaPremierSoin;
import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Medecin extends Personnage {

	public Medecin() {
		super();
		this.combat = new EspritCombatifAmbrMedCur();
		this.soin = new SoinEmmaPremierSoin();
		this.deplacement = new DeplacementAmbrMedBio();
	}

	public Medecin(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
		// TODO Auto-generated constructor stub
	}

}
