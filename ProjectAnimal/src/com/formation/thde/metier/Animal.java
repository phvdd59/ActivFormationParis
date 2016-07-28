package com.formation.thde.metier;

public abstract class Animal {

	private int poids;
	private String couleur;

	public abstract int manger();

	public abstract int boire();

	public abstract int deplacement();

	public abstract int crier();
}
