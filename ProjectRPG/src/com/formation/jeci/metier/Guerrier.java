package com.formation.jeci.metier;

import com.formation.emma.inter.Soin;
import com.formation.emma.metier.NeSoignePAs;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.made.metier.Sauter;
import com.formation.thde.inter.EspritCombatif;
import com.formation.thde.metier.CombatHache;

public class Guerrier extends Personnage {

	public Guerrier() {
		this.combat = new CombatHache();
		this.deplacement = new Sauter();
		this.soin = new NeSoignePAs();

	}

	public Guerrier(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);

	}


}
