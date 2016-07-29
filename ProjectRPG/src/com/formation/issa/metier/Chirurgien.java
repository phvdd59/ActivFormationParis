package com.formation.issa.metier;

import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Chirurgien extends Personnage implements EspritCombatif, Deplacement, Soin {

	
	public Chirurgien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chirurgien(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
		// TODO Auto-generated constructor stub
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
