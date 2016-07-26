package com.formation.anfr.metier;

import java.util.ArrayList;

import com.formation.anfr.metier.EntrepotMap;
import com.formation.anfr.metier.Wagon;

public class RER extends ArrayList<Wagon> {
	

	
	

	public void creTrain(EntrepotMap entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				add(entrepot.remove(typeWagon.WAGON_SIMPLE1.ordinal(),entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE1)));
			} else {
				add(entrepot.remove(typeWagon.WAGON_SIMPLE2.ordinal(),entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE2)));
			}
			if (i == nbWagon / 2) {
				add(entrepot.remove(typeWagon.WAGON_RESTO.ordinal(),entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_RESTO)));
			}
		}
	}
	
	public void ajoutWagon(int type,EntrepotMap entrepot) {
		add(entrepot.remove(type,0));
	}

	@Override
	public boolean add(Wagon wagon) {
		return super.add(wagon);
	}
	
	
}
