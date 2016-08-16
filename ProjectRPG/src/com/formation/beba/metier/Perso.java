package com.formation.beba.metier;

import com.formation.beba.inter.Combat;
import com.formation.beba.inter.Deplacement;
import com.formation.beba.inter.Soin;

public abstract class Perso {

	public Combat combat;
	public Deplacement deplacement;
	public Soin soin;
	public String nom;

	public Perso(String nom, Combat combat, Deplacement deplacement, Soin soin) {
		super();
		this.nom = nom;
		this.combat = combat;
		this.deplacement = deplacement;
		this.soin = soin;
	}

	public Perso() {
	}

	public void combattre() {
		combat.combat();
	}

	public void seDeplacer() {
		deplacement.deplacer();
	}

	public void soigner() {
		soin.soigne();
	}

}
