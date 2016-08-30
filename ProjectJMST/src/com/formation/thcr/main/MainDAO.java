package com.formation.thcr.main;

import com.formation.thcr.dao.DAO;
import com.formation.thcr.metier.Personne;

public class MainDAO {

	public static void main(String[] args) {
		DAO dao = new DAO();
		Personne personne = new Personne();
		personne.setLogin("test");
		personne.setAdmin(false);
		System.out.println(dao.read(personne));


	}

}
