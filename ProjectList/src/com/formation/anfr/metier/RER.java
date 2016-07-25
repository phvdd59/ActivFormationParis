package com.formation.anfr.metier;

import java.util.ArrayList;

import com.formation.phva.metier.Entrepot;
import com.formation.phva.metier.Wagon;

public class RER extends ArrayList<Wagon> {
	

	
	

	public void creTrain(EntrepotMap entrepot, int nbWagon) {
		for (int i = 0; i < nbWagon; i++) {
			if (i % 4 == 0) {
				add(entrepot.remove(Wagon.WAGON_SIMPLE1,entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE1)));
			} else {
				add(entrepot.remove(Wagon.WAGON_SIMPLE2,entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_SIMPLE2)));
			}
			if (i == nbWagon / 2) {
				add(entrepot.remove(Wagon.WAGON_RESTO,entrepot.trouverLeDernierWagonDuMemeType(Wagon.WAGON_RESTO)));
			}
		}
	}
	
	public void ajoutWagon(int type,EntrepotMap entrepot) {
		add(entrepot.remove(type,0));
	}

	@Override
	public boolean add(Wagon e) {
		return super.add(e);
	}
	
	
}
