package com.formation.joca.metier;

import com.formation.emma.inter.Soin;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Personnage implements EspritCombatif, Deplacement, Soin {

	private EspritCombatif combat;
	private Deplacement deplacement;
	private Soin soin;

	public Personnage(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super();
		this.combat = combat;
		this.deplacement = deplacement;
		this.soin = soin;
	}

	public EspritCombatif getCombat() {
		return combat;
	}

	public void setCombat(EspritCombatif combat) {
		this.combat = combat;
	}

	public Deplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}

	public Soin getSoin() {
		return soin;
	}

	public void setSoin(Soin soin) {
		this.soin = soin;
	}

	public void seDeplacer() {

	}

	public void combattre() {

	}

	public void soigner() {

	}

	@Override
	public void soigne() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void combat() {
		// TODO Auto-generated method stub

	}

}
