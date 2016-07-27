package com.formation.phva.exo;

public class Mouvement {

	private int taille;
	private String from;
	private String to;
	public Mouvement(int indice, String from, String to) {
		super();
		this.taille = indice;
		this.from = from;
		this.to = to;
	}
	public int getTaille() {
		return taille;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	@Override
	public String toString() {
		return "Bougez le disque " + taille + " de " + from + " à " + to;
	}
}
