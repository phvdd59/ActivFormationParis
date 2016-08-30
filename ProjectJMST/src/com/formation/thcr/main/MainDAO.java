package com.formation.thcr.main;

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;

public class MainDAO {

	public static void main(String[] args) {
		DAOPersonne dao = new DAOPersonne();
		Personne personne = new Personne();
		personne.setIdentifiant("test");
		personne.setAdmin(false);
		System.out.println(dao.read(personne));


	}

}
