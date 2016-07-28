package com.formation.soka.metier;

import com.formation.thcr.metier.Felin;
import com.formation.thde.metier.Animal;

public class Lion extends Felin {

	public Lion() {
		super(180, "rouge");
	}

	public Lion(int poids, String couleur) {
		super(poids, couleur);
	}

	@Override
	public void manger() {
		System.out.println("Je mange tous les animaux de la Jungle");
	}

	@Override
	public void boire() {
		System.out.println("Je bois, je bois");

	}

	@Override
	public void deplacement() {
		System.out.println("Je me d�place pour mieux dig�rer");

	}

	@Override
	public void crier() {
		System.out.println("Je rugis apr�s avoir bien mang�");

	}

}
