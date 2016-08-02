package com.formation.soka.metier;

import com.formation.comportement.EspritCombatifSokaPacifiste;
import com.formation.comportement.SoinSokaDoliprane;
import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.made.metier.NeBougePas;
import com.formation.thde.inter.EspritCombatif;

public class Civil extends Personnage {

	public Civil() {
		super(new EspritCombatifSokaPacifiste(), new NeBougePas(), new SoinSokaDoliprane());
	}

	public Civil(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
	}
}
