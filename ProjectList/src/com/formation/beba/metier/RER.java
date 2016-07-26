package com.formation.beba.metier;

import java.util.ArrayList;

public class RER extends ArrayList<Wagon> {

	public void creTrain(Entrepot2 entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				Wagon wagonSimple = entrepot.get(TypeWagon.WAGON_SIMPLE1).remove(entrepot.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_SIMPLE1.getType()));
				add(wagonSimple);
			} else {
				add(entrepot.get(TypeWagon.WAGON_SIMPLE2).remove(entrepot.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_SIMPLE2.getType())));
			}
			if (i == nbWagon / 2) {
				add(entrepot.get(TypeWagon.WAGON_RESTO).remove(entrepot.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_RESTO.getType())));
			}
		}
	}

	@Override
	public boolean add(Wagon e) {
		return super.add(e);
	}

}
