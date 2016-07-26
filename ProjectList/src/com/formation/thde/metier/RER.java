package com.formation.thde.metier;

import java.util.ArrayList;

public class RER extends ArrayList<Wagon> {

	public void creTrain(EntrepotMap entrepotMap, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				add(entrepotMap.get(TypeWagon.WAGON_SIMPLE1.getType()).remove(entrepotMap.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_SIMPLE1.getType())));
			} else {
				add(entrepotMap.get(TypeWagon.WAGON_SIMPLE2.getType()).remove(entrepotMap.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_SIMPLE2.getType())));
			}
			if (i == nbWagon / 2) {
				add(entrepotMap.get(TypeWagon.WAGON_RESTO.getType()).remove(entrepotMap.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_RESTO.getType())));
			}
		}
	}

	public void creTrain(Entrepot entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				add(entrepot.remove(entrepot.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_SIMPLE1.getType())));
			} else {
				add(entrepot.remove(entrepot.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_SIMPLE2.getType())));
			}
			if (i == nbWagon / 2) {
				add(entrepot.remove(entrepot.trouverLeDernierWagonDuMemeType(TypeWagon.WAGON_RESTO.getType())));
			}
		}
	}
}
