package com.formation.jeci.metier;

import com.formation.comportement.DeplacementJeCi;
import com.formation.comportement.EspritCombatifJeCi;
import com.formation.comportement.SoinJeCI;
import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Guerrier extends Personnage {

	public Guerrier() {
		this.combat = new EspritCombatifJeCi();
		this.deplacement = new DeplacementJeCi();
		this.soin = new SoinJeCI();

	}//

	public Guerrier(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
	}

}
