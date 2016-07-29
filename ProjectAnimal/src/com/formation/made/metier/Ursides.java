package com.formation.made.metier;

import com.formation.etga.Interface.Lapper;
import com.formation.thde.metier.Animal;

public class Ursides extends Animal implements Lapper {

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

}
