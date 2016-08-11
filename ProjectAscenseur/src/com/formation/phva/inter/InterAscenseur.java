package com.formation.phva.inter;

public interface InterAscenseur extends Runnable {
	public int HAUTEUR_ETAGE=30;

	public String getName();

	public InterPersonne getPersonne();

	public void start();

	public int getEtage();

	public int getProgression();
}
