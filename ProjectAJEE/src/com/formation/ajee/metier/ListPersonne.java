package com.formation.ajee.metier;

import java.util.ArrayList;

import com.formation.ajee.dao.DaoBDD;
import com.formation.ajee.dao.DaoPersonne;

public class ListPersonne extends ArrayList<Personne> {

	private Personne personne;
	
	DaoPersonne dao = new DaoPersonne();
	DaoBDD dao1 = new DaoBDD();

	public ListPersonne() {

		ArrayList<Personne> listepersonne = dao.lectureTable();
		this.addAll(listepersonne);
	}
	public ListPersonne(int num) {

		ArrayList<Personne> listepersonne = dao1.lectureTableBackUp();
		this.addAll(listepersonne);
	}
}
