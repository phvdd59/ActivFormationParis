package com.formation.thcr.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Medecin;
import com.formation.comportement.EspritCombatifAmbrMedCur;
import com.formation.comportement.EspritCombatifEtgaCombatFusilALunette;
import com.formation.comportement.EspritCombatifJeCi;
import com.formation.comportement.EspritCombatifSokaPacifiste;
import com.formation.comportement.EspritCombatifThcrCombatMainNue;
import com.formation.emma.metier.Operation;
import com.formation.emma.metier.PremierSoin;
import com.formation.emma.metier.Sevanouir;
import com.formation.etga.metier.Sniper;
import com.formation.issa.metier.Chirurgien;
import com.formation.jeci.metier.Guerrier;
import com.formation.joca.metier.Personnage;
import com.formation.made.metier.Courrir;
import com.formation.made.metier.Marcher;
import com.formation.made.metier.NeBougePas;
import com.formation.soka.metier.Civil;

public class MainRPG {

	public static void main(String[] args) {
		MainRPG main = new MainRPG();
		main.init();
	}

	private void init() {
		//TODO instanciation de tous les persos et mis en pllace des m�thodes
		Personnage civil = new Civil(new EspritCombatifSokaPacifiste(), new Courrir(),
				new Sevanouir());
		Personnage sniper = new Sniper(new EspritCombatifEtgaCombatFusilALunette(),
				new NeBougePas(), new PremierSoin());
		Personnage guerrier = new Guerrier(new EspritCombatifThcrCombatMainNue(), new Marcher(),
				new PremierSoin());
		Personnage medecin = new Medecin(new EspritCombatifAmbrMedCur(), new Courrir(),
				new PremierSoin());
		Personnage chirurgien = new Chirurgien(new EspritCombatifJeCi(), new Courrir(),
				new Operation());

		Personnage civil2 = new Civil();
		System.out.println(civil2.getClass().getName());
		civil2.combattre();
		civil2.soigner();
		civil2.seDeplacer();
		System.out.println("---------------------------------");

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
