package com.formation.emma.ctr;

public class RepetitionMot {

	private String categorie;
	private int repetition;
	
	
	public RepetitionMot(String categorie, int repetition) {
		super();
		this.categorie = categorie;
		this.repetition = repetition;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public int getRepetition() {
		return repetition;
	}


	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
	
}
