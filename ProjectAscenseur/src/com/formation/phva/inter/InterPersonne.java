package com.formation.phva.inter;

import com.formation.phva.metierz.ETAT;

public interface InterPersonne {

	public String getNom();

	public int getDepart();

	public int getArrivee();

	public ETAT getEtat();
}
