package com.formation.joca.metier;

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

	public void creTrainSimple(EntrepotMap entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				add(entrepot.get(Wagon.WAGON_SIMPLE1).remove(entrepot.get(Wagon.WAGON_SIMPLE1).size() - 1));
			} else {
				add(entrepot.get(Wagon.WAGON_SIMPLE2).remove(entrepot.get(Wagon.WAGON_SIMPLE2).size() - 1));
			}
			if (i == nbWagon / 2) {
				add(entrepot.get(Wagon.WAGON_RESTO).remove(entrepot.get(Wagon.WAGON_RESTO).size() - 1));
			}
		}
	}

	public void creTrainDouble(EntrepotMap entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i == nbWagon / 2) {
				add(entrepot.get(Wagon.WAGON_RESTO).remove(entrepot.get(Wagon.WAGON_RESTO).size() - 1));
			} else {
				add(entrepot.get(Wagon.WAGON_DOUBLE).remove(entrepot.get(Wagon.WAGON_DOUBLE).size() - 1));
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
