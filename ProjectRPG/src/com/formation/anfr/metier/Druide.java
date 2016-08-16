package com.formation.anfr.metier;

import com.formation.comportement.DeplacementAnfrLoup;
import com.formation.comportement.EspritCombatifAnfrLianes;
import com.formation.comportement.InvocAnfrSanglier;
import com.formation.comportement.SoinAnfrBaies;
import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Druide extends Personnage {
	public Invocation invoker;
	
	public Druide() {
		super();
		this.combat = new EspritCombatifAnfrLianes();
		this.soin = new SoinAnfrBaies();
		this.deplacement = new DeplacementAnfrLoup();
		this.invoker = new InvocAnfrSanglier();
	}

	public Druide(EspritCombatif combat, Deplacement deplacement, Soin soin, Invocation invoc) {
		super(combat, deplacement, soin);
		this.invoker = invoc;
		// TODO Auto-generated constructor stub
	}
}
