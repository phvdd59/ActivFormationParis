package com.formation.ajee.metier;

import java.util.ArrayList;

import com.formation.ajee.dao.DaoDocument;

public class ListeDoc extends ArrayList<DocPerso> {
	private static final long serialVersionUID = 1L;
	private DaoDocument daoD = new DaoDocument();
	private Personne personne;

	public ListeDoc() {
		daoD.lectureTable(personne.getIdPersonne());
	}

}
