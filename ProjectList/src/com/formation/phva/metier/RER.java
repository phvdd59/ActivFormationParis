package com.formation.phva.metier;

import java.util.ArrayList;

public class RER extends ArrayList<Wagon> {
	
	
	

	public void creTrain(Entrepot entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				add(entrepot.remove(entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE1)));
			} else {
				add(entrepot.remove(entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE2)));
			}
			if (i == nbWagon / 2) {
				add(entrepot.remove(entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_RESTO)));
			}
		}
	}
	
	public void ajoutWagon(Entrepot entrepot) {
		add(entrepot.remove(0));
	}

	@Override
	public boolean add(Wagon e) {
		return super.add(e);
	}
	
}
