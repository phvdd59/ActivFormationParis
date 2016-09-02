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
		Personne jojo = new Personne("anfr","admin");
		jojo.setNom("FRERE");
		jojo.setPrenom("Antoine");
		jojo.setEmail("anfr@activConsulting.fr");
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		bdd.createNewPersonne(momo.getIdentifiant(), momo.getMdp(), momo.getEmail(), momo.getNom(), momo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		lstPersonnes = bdd.findAllUserId();
		for (int i = 0; i < lstPersonnes.size(); i++) {
			System.out.println(lstPersonnes.isEmpty());
			toto = bdd.getPersonne(lstPersonnes.get(i));
			toto.setAdresse("15 rue du Flood");
			bdd.savePersonne(toto);
		}
	}

}
