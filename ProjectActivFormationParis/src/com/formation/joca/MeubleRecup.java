package com.formation.joca;

import java.util.ArrayList;

public class MeubleRecup implements Comparable<MeubleRecup> {
	private String Numserie;
	public int nombre;

	public String getNumserie() {
		return Numserie;
	}

	public void setNumserie(String numserie) {
		Numserie = numserie;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public MeubleRecup(String numserie) {
		super();
		Numserie = numserie;
		this.nombre = 1;
	}

	public void EstDansListe(ArrayList<MeubleRecup> liste) {
		boolean trouve = false;
		int i = 0;
		while (!trouve && i < liste.size()) {
			if (liste.get(i).getNumserie().equals(this.Numserie)) {
				trouve = true;
				liste.get(i).setNombre(liste.get(i).getNombre() + 1);
			} else {
				i++;
			}
		}
		if (trouve == false) {
			liste.add(this);
		}

	}

	@Override
	public int compareTo(MeubleRecup o) {
		if (this.nombre < o.getNombre()) {
			return -1;
		} else if (this.nombre < o.getNombre()) {
			return 1;
		} else {
			return 0;
		}
	}

}
