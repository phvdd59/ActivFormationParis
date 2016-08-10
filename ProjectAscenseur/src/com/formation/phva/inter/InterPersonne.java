package com.formation.phva.inter;

public interface InterPersonne {

	public String getNom();

	public int getDepart();

	public int getArrivee();

	public InterETAT getEtat();

	public void setEtat(InterETAT etat);
}