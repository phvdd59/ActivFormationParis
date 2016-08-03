package com.formation.made.exo;

import java.util.ArrayList;

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

	public void bougerbouger(ArrayList<Integer> list1, ArrayList<Integer> list2, int indice) {
		list1.add(list2.remove(indice));
	}
}
