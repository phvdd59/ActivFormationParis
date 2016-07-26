package com.formation.etga.metier;

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

	public void permuter1en1(int indice1) {
		add(indice1, remove(indice1 + 1));
	}

	public void tri1() {
		boolean permuteAuMoinsUneFois = true;
		while (permuteAuMoinsUneFois) {
			permuteAuMoinsUneFois = false;
			for (int i = 0; i < this.size() - 1; i++) {
				if (this.get(i).compareTo(get(i + 1)) == 1) {
					permuter1en1(i);
					permuteAuMoinsUneFois = true;
				}
			}
		}
	}

	public void tri2() {
		int[] ordreDeTri = { Wagon.WAGON_SIMPLE2, Wagon.WAGON_DOUBLE, Wagon.WAGON_SIMPLE1, Wagon.WAGON_RESTO };
		// int entierTri = 0;
		int cpt = 0;
		for (int entierTri = 0; entierTri < ordreDeTri.length - 1; entierTri++) {
			if (this.get(cpt).getType() != ordreDeTri[entierTri]) {
				for (int i = cpt + 1; i < this.size(); i++) {
					if (this.get(i).getType() == ordreDeTri[entierTri]) {
						add(cpt, remove(i));
						cpt++;
						i--;
					}
				}
			}
		}

	}

	@Override
	public void add(int index, Wagon element) {
		nbTypeWagons[element.getType()]++;
		super.add(index, element);
	}

	@Override
	public Wagon remove(int index) {
		Wagon element = get(index);
		nbTypeWagons[element.getType()]++;
		return super.remove(index);
	}

}
