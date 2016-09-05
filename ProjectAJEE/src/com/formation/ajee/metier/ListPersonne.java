package com.formation.ajee.metier;

import java.util.ArrayList;

import com.formation.ajee.dao.DaoPersonne;

public class ListPersonne extends ArrayList<Personne> {

	private Personne personne;
	DaoPersonne dao = new DaoPersonne();

	public ListPersonne() {

		ArrayList<Personne> listepersonne = dao.lectureTable();
		this.addAll(listepersonne);
	}
}
