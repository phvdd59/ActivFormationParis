package com.formation.made.metier;

import com.formation.etga.Interface.Lapper;
import com.formation.soka.interfaces.Vivipare;
import com.formation.thde.metier.Animal;

public class Ursides extends Animal implements Lapper, Vivipare {

	public Ursides(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void manger() {

	}

	@Override
	public void boire() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deplacement() {
		System.out.println("les ursidés se déplacent dodelinant");

	}

	@Override
	public void crier() {
		System.out.println("les ursidés grognent");

	}

	@Override
	public void lapper() {
		System.out.println("les ursidés boivent dans les rizières");

	}

	@Override
	public void gestation() {
		System.out.println("les femelles pandas ont une période de gestion");

	}

	@Override
	public boolean egale(Animal animal) {
		// TODO Auto-generated method stub
		return false;
	}

}
