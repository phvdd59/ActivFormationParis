package com.formation.thcr.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Medecin;
import com.formation.etga.metier.Sniper;
import com.formation.issa.metier.Chirurgien;
import com.formation.jeci.metier.Guerrier;
import com.formation.joca.metier.Personnage;
import com.formation.made.metier.Courrir;
import com.formation.made.metier.Marcher;
import com.formation.made.metier.NeBougePas;
import com.formation.soka.metier.Civil;
import com.formation.thde.metier.CombatCouteau;
import com.formation.thde.metier.CombatPistolet;
import com.formation.thde.metier.PasDeCombat;

public class MainRPG {

	public static void main(String[] args) {
		MainRPG main = new MainRPG();
		main.init();
	}

	private void init() {
		//TODO instanciation de tous les persos et mis en pllace des méthodes
		Personnage civil = new Civil(new PasDeCombat(), new Courrir(), new Sevanouir());
		Personnage sniper = new Sniper(new CombatPistolet(), new NeBougePas(), new PremierSoin());
		Personnage guerrier = new Guerrier(new CombatCouteau(), new Marcher(), new SoignePas());
		Personnage medecin = new Medecin(new CombatCouteau(), new Courrir(), new PremierSoin());
		Personnage chirurgien = new Chirurgien(new CombatCouteau(), new Courrir(), new Opeartion());

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
