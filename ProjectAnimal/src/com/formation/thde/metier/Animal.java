package com.formation.thde.metier;

public abstract class Animal {

	private int poids;
	private String couleur;

	public abstract void manger();

	public abstract void boire();

	public abstract void deplacement();

	public abstract void crier();
}
