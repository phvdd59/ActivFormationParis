package com.formation.issa.main;

import java.util.ArrayList;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainTest {

	public static void main(String[] args) {
		MainTest m = new MainTest();
		m.init();

	}

	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		Personne jojo = new Personne("issatest1", "admin");
		jojo.setNom("FRERE");
		jojo.setPrenom("Antoine");
		jojo.setEmail("anfr@activConsulting.fr");
	
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		Personne momo = new Personne("issatest2", "admin");
		momo.setNom("PARIS");
		momo.setPrenom("Judith");
		bdd.createNewPersonne(momo.getIdentifiant(), momo.getMdp(), momo.getEmail(), momo.getNom(), momo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		lstPersonnes = bdd.findAllUserId();
		for (int i = 0; i < lstPersonnes.size(); i++) {
			System.out.println(lstPersonnes.isEmpty());
			jojo = bdd.getPersonne(lstPersonnes.get(i));
			jojo.setAdresse("15 rue du Flood");
			bdd.savePersonne(jojo);
			bdd.getPersonne("35");


		}

	}
}
