package com.formation.thcr.main;

import java.util.ArrayList;

import com.formation.joca.metier.Personnage;
import com.formation.soka.metier.Civil;

public class MainRPG {

	public static void main(String[] args) {
		MainRPG main = new MainRPG();
		main.init();
	}

	private void init() {
		//TODO instanciation de tous les persos et mis en pllace des méthodes
		Personnage civil = new Civil();
		Personnage sniper = new Sniper();
		Personnage guerrier = new Guerrier();
		Personnage medecin = new Medecin();
		Personnage chirurgien = new Chirurgien();

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
