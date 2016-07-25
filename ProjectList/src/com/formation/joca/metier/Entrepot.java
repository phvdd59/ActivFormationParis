package com.formation.joca.metier;

import java.util.ArrayList;

public class Entrepot extends ArrayList<Wagon> {
	private static int[] POURCENT_TYPE = { 14, 14, 44, 28 };

	private int[] nbTypeWagons;
	private int[] pourcentType;

	public Entrepot() {
		nbTypeWagons = new int[4];
		pourcentType = new int[4];
		pourcentType[Wagon.WAGON_RESTO] = 14;
		pourcentType[Wagon.WAGON_SIMPLE1] = 14;
		pourcentType[Wagon.WAGON_SIMPLE2] = 44;
		pourcentType[Wagon.WAGON_DOUBLE] = 100;
		for (int i = 0; i < nbTypeWagons.length; i++) {
			if (i != Wagon.WAGON_DOUBLE) {
				pourcentType[Wagon.WAGON_DOUBLE] -= pourcentType[i];
			}
		}

	}

	public Entrepot(int nb) {
		fabrique(nb);
	}

	public void fabrique(int nbWagon) {
		int nbWagonRestoARajouter = (nbWagon * pourcentType[Wagon.WAGON_RESTO]) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			add(new WagonResto());
		}
		int nbWagon1ereARajouter = (nbWagon * pourcentType[Wagon.WAGON_SIMPLE1]) / 100;
		nTotal += nbWagon1ereARajouter;
		for (int i = 0; i < nbWagon1ereARajouter; i++) {
			add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
		}
		int nbWagon2ereARajouter = (nbWagon * pourcentType[Wagon.WAGON_SIMPLE2]) / 100;
		nTotal += nbWagon2ereARajouter;
		for (int i = 0; i < nbWagon2ereARajouter; i++) {
			add(new WagonSimple(WagonSimple.SECONDE_CLASSE));
		}
		int nbWagonDoubleARajouter = nbWagon - nTotal;
		for (int i = 0; i < nbWagonDoubleARajouter; i++) {
			add(new WagonDouble());
		}
	}

	public int trouverLeDernierWagonDuMemeType(int type) {
		int indexDeRetour = -1;
		for (int i = size() - 1; i >= 0; i--) {
			if (get(i).getType() == type) {
				indexDeRetour = i;
				break;
			}
		}
		return indexDeRetour;
	}

	@Override
	public boolean add(Wagon e) {
		nbTypeWagons[e.getType()]++;
		return super.add(e);
	}

	public void trier() {
		ArrayList<Wagon> listWagonResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonDouble = new ArrayList<Wagon>();

		for (int i = 0; i < this.size(); i++) {
			switch (this.get(i).getType()) {
			case 0:
				listWagonResto.add(this.get(i));
				break;
			case 1:
				listWagonSimple1.add(this.get(i));
				break;
			case 2:
				listWagonSimple2.add(this.get(i));
				break;
			case 3:
				listWagonDouble.add(this.get(i));
				break;
			}
		}

		this.clear();
		this.addAll(listWagonSimple2);
		this.addAll(listWagonDouble);
		this.addAll(listWagonSimple1);
		this.addAll(listWagonResto);
	}
}
