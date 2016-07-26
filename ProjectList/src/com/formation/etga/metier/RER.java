package com.formation.etga.metier;

import java.util.ArrayList;

public class RER extends ArrayList<Wagon> {

	public void creTrain(EntrepotMap entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				Wagon wagonSimple = entrepot.get(Wagon.WAGON_SIMPLE1).remove(entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE1));
				add(wagonSimple);
			} else {
				add(entrepot.get(Wagon.WAGON_SIMPLE2).remove(entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE2)));
			}
			if (i == nbWagon / 2) {
				add(entrepot.get(Wagon.WAGON_RESTO).remove(entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_RESTO)));
			}
		}
	}

	@Override
	public boolean add(Wagon e) {
		return super.add(e);
	}
}
