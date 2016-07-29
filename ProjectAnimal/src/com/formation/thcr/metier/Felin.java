package com.formation.thcr.metier;

import com.formation.etga.Interface.Lapper;
import com.formation.soka.interfaces.Vivipare;
import com.formation.thde.metier.Animal;

public abstract class Felin extends Animal implements Lapper, Vivipare{

	public Felin() {
		super();
	}

	public Felin(int poids, String couleur) {
		super(poids, couleur);

	}

	@Override
	public abstract void manger();

	@Override
	public abstract void boire();

	@Override
	public abstract void deplacement();

	@Override
	public abstract void crier();

}
