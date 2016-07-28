package com.formation.anfr.exo;

public class Mouvement {

	private int indice;
	private String from;
	private String to;
	public Mouvement(int indice, String from, String to) {
		super();
		this.indice = indice;
		this.from = from;
		this.to = to;
	}
	public int getTaille() {
		return indice;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	@Override
	public String toString() {
		return "Bougez le disque " + indice + " de " + from + " à " + to;
	}
}
