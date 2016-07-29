package com.formation.made.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Corneille;
import com.formation.emma.metier.Chien;
import com.formation.etga.Interface.Lapper;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.jeci.metier.Oiseaux;
import com.formation.joca.metier.Pangolin;
import com.formation.made.metier.Panda;
import com.formation.soka.interfaces.Vivipare;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;
import com.formation.thde.metier.Animal;

public class MainAnimal {

	public static void main(String[] args) {
		MainAnimal mainAnimal = new MainAnimal();
		mainAnimal.init();

	}

	private void init() {
		Animal monpanda = new Panda();
		monpanda.setCouleur("roux");
		monpanda.setPoids(60);
		System.out.println("Mon panda est " + monpanda.getCouleur() + " et fait " + monpanda.getPoids() + " kilos");
		Lion monlion = new Lion();
		monlion.crier();
		// System.out.println(monlion.crier());
		monpanda.boire();
		Oiseaux macorneille = new Corneille();
		macorneille.boire();
		Oiseaux aigle = new Aigle();
		Lapper lapper1 = new Panda();
		Recueille re = aigle;
		re.recueille();
		ArrayList<Lapper> lstLapper = new ArrayList<Lapper>();
		lstLapper.add(new Pangolin(4, "Marron"));
		lstLapper.add(new Panda(300, "Noir tacheté de blanc"));
		lstLapper.add(new Lion(80, "Orange"));
		lstLapper.add(new Chien(30, "Noir"));
		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper();
		}
		Lapper lapper = new Panda();
		lapper.lapper();
		Recueille receuille1 = new Corneille();
		receuille1.recueille();
		Recueille receuille2 = new Aigle();
		receuille2.recueille();

		ArrayList<Ovipare> lstOvipare = new ArrayList<Ovipare>();
		lstOvipare.add(new Aigle(2, "Noir"));
		lstOvipare.add(new Corneille(2,"3eyed raven"));
		for (int i = 0; i < lstOvipare.size(); i++) {
			lstOvipare.get(i).pondre();
		 {
		}
	}
		ArrayList<Vivipare> lstVivipare = new ArrayList<Vivipare>();
		lstVivipare.add(new Lion(25, "Noir"));
		lstVivipare.add(new Panda(20,"3eyed raven"));
		for (int i = 0; i < lstVivipare.size(); i++) {
			lstVivipare.get(i).gestation();;
		 {
		
	}
}
	}
	
}
