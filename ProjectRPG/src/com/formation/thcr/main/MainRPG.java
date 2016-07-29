package com.formation.thcr.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Medecin;
import com.formation.emma.inter.Soin;
import com.formation.etga.metier.Sniper;
import com.formation.issa.metier.Chirurgien;
import com.formation.joca.metier.Personnage;
import com.formation.made.inter.Deplacement;
import com.formation.soka.metier.Civil;
import com.formation.thde.inter.EspritCombatif;

public class MainRPG {

	public static void main(String[] args) {
		MainRPG main = new MainRPG();
		main.init();
	}

	private void init() {
		//TODO instanciation de tous les persos et mis en pllace des méthodes
		Personnage civil = new Civil(new EspritCombatif(), new Deplacement(), new Soin());
		Personnage sniper = new Sniper(new EspritCombatif(), new Deplacement(), new Soin());
		Personnage guerrier = new Guerrier(new EspritCombatif(), new Deplacement(), new Soin());
		Personnage medecin = new Medecin(new EspritCombatif(), new Deplacement(), new Soin());
		Personnage chirurgien = new Chirurgien(new EspritCombatif(), new Deplacement(), new Soin());

		ArrayList<Personnage> list = new ArrayList<Personnage>();
		list.add(civil);
		list.add(sniper);
		list.add(guerrier);
		list.add(medecin);
		list.add(chirurgien);

		for (Personnage personnage : list) {
			System.out.println(personnage.getClass().getName());
			personnage.seDeplacer();
			personnage.combattre();
			personnage.soigner();
			System.out.println("---------------------------------");
		}

	}

}
