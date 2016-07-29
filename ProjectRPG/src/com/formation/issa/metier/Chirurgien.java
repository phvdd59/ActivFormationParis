package com.formation.issa.metier;

import com.formation.comportement.DeplacementChirurgien;
import com.formation.comportement.EspritCombatifChirugien;
import com.formation.comportement.SoinScalpel;
import com.formation.emma.inter.Soin;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.thde.inter.EspritCombatif;

public class Chirurgien extends Personnage  {

	
	public Chirurgien() {
		super();
		this.combat= new EspritCombatifChirugien();
		this.deplacement=new DeplacementChirurgien();
		this.soin=new SoinScalpel();
		// TODO Auto-generated constructor stub
	}
	public Chirurgien(EspritCombatif combat, Deplacement deplacement, Soin soin) {
		super(combat, deplacement, soin);
		
	}
//	@Override
//	public void soigne() {
//		System.out.println("Je triture les gens");
//		
//	}
//	@Override
//	public void deplacer() {
//		System.out.println( "Je cours de bloc en bloc");
//		
//		
//		
//	}
//	@Override
//	public void combat() {
//		
//		System.out.println("Je combats au scapel");
//		
//		
//	}

}
