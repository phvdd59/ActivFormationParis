package com.formation.joca.exo;

import java.util.ArrayList;
import java.util.Collections;

public class AideExo5 {

	private ArrayList liste;

	public AideExo5() {
		super();
	}

	public ArrayList getListe() {
		return liste;
	}

	public void setListe(ArrayList liste) {
		this.liste = liste;
	}

	public void ChangerEnListe(char[] tab) {
		for (int i = 0; i < tab.length; i++) {
			this.liste.add(tab[i]);
		}
	}

	public void Ranger() {
		Collections.sort(this.liste);
	}

}
