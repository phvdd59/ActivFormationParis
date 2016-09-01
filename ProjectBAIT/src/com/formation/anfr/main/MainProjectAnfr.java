package com.formation.anfr.main;

import java.util.ArrayList;

import com.formation.bait.dao.AccesBDD;
import com.formation.bait.metier.Personne;

public class MainProjectAnfr {

	public static void main(String[] args) {
		MainProjectAnfr m = new MainProjectAnfr();
		m.init();

	}

	private void init() {
		AccesBDD bdd = new AccesBDD();
		Personne jojo = new Personne("JOJO","JOJO76");
		Personne toto = new Personne("","");
		jojo.setNom("Bueller");
		jojo.setPrenom("Joris");
		jojo.setEmail("jojo76@serieall.fr");
		Personne momo = new Personne("MOMO","JOJO76");
		momo.setNom("Bueller");
		momo.setPrenom("Moris");
		momo.setEmail("momo76@serieall.fr");
	//	bdd.creTables();
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
