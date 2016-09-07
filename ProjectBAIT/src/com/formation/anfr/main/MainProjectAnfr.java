package com.formation.anfr.main;

import java.util.ArrayList;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainProjectAnfr {

	public static void main(String[] args) {
		MainProjectAnfr m = new MainProjectAnfr();
		m.init();

	}

	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		bdd.creTablesSauv();
	}

}
