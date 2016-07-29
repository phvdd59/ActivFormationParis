package com.formation.emma.main;

import java.util.ArrayList;

import com.formation.beba.metier.Tigre;
import com.formation.emma.metier.Chien;
import com.formation.etga.Interface.Lapper;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.metier.Aigle;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;

public class MainAnimal {
	public static void main(String[] args) {

		Chien chien = new Chien(5, "noir");
		chien.boire();
		Aigle aigle = new Aigle();
		aigle.deplacement();

		ArrayList<Lapper> listeLapper = new ArrayList<Lapper>();
		listeLapper.add(new Lion(30, "marron"));
		listeLapper.add(new Chien());
		listeLapper.add(new Tigre(120, "roux"));
		for (int i = 0; i < listeLapper.size(); i++) {
			listeLapper.get(i).lapper();
		}

		ArrayList<Ovipare> listeOvipare = new ArrayList<Ovipare>();
		listeOvipare.add(new Aigle(2, "blanc"));
		listeOvipare.add(new Saumon(1, "rose"));
		for (int i = 0; i < listeOvipare.size(); i++) {
			listeOvipare.get(i).pondre();
		}

	}
}
