package com.formation.issa.main;

import com.formation.ambr.metier.Medecin;
import com.formation.etga.metier.Sniper;
import com.formation.issa.metier.Chirurgien;
import com.formation.jeci.metier.Guerrier;
import com.formation.joca.metier.Personnage;
import com.formation.soka.metier.Civil;

public class MainRPG {

	public static void main(String[] args) {
		MainRPG mainRPG=new MainRPG();
		mainRPG.init();
		
	}

	private void init() {
	Personnage civil=new Civil();
	Personnage guerrier=new Guerrier();
	Personnage chirurgien=new Chirurgien();
	Personnage medecin=new Medecin();
	Personnage sniper=new Sniper();
	
		
	}

}
