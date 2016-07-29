package com.formation.ambr.main;

import com.formation.ambr.metier.Medecin;
import com.formation.comportement.DeplacementThcrRampe;
import com.formation.comportement.EspritCombatifAmbrMedCur;
import com.formation.comportement.SoinEmmaPremierSoin;

public class MainRPG {

	public static void main(String[] args) {
		MainRPG mainRPG = new MainRPG();
		mainRPG.init();

	}

	private void init() {
		Medecin medecin = new Medecin(new EspritCombatifAmbrMedCur(), new DeplacementThcrRampe(), new SoinEmmaPremierSoin());
		System.out.println(medecin);
	}

}
