package com.formation.thde.ctr;

public class Meuble implements Comparable<Meuble> {
	String numero;
	int nombre;

	public Meuble(String numero) {
		this.numero = numero;
		this.nombre = 0;
	}

	public Meuble(String numero, int nombre) {
		this.numero = numero;
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Meuble o) {
		int result = 0;
		if (this.getNombre() > o.getNombre()) {
			result = -1;
		} else if (this.getNombre() < o.getNombre()) {
			result = 1;
		} else {
			result = (int) this.getNumero().compareTo(o.getNumero());
		}
		return result;
	}

	public void plusUn() {
		this.nombre += 1;

	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Meuble temp = (Meuble) obj;
		if (this.getNumero().equals(temp.getNumero())) {
			result = true;
		}
		return result;
	}

}