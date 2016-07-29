package com.formation.soka.metier;

import com.formation.emma.inter.Soin;
import com.formation.emma.metier.Sevanouir;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.made.metier.NeBougePas;
import com.formation.thde.inter.EspritCombatif;
import com.formation.thde.metier.PasDeCombat;

public class Civil extends Personnage {

	public Civil() {
		super(new PasDeCombat(), new NeBougePas(), new Sevanouir());
	}
	
	public Civil(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
	}
}
