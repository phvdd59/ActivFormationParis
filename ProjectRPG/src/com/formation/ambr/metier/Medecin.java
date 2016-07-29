package com.formation.ambr.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Medecin extends Personnage implements Soin, Deplacement, EspritCombatif {

	public Medecin(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void combat() {
		System.out.println("J'injecte une solution de curare");
	}

	@Override
	public void deplacer() {
		System.out.println("Je me d�place super vite gr�ce � mes proth�ses bioniques");
	}

	@Override
	public void soigne() {
		System.out.println("Je diagnostique et r�alise les soins n�cessaires");
	}

}
