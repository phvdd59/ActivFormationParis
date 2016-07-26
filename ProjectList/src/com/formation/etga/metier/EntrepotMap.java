package com.formation.etga.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class EntrepotMap extends TreeMap<Integer, ArrayList<Wagon>> {

	private static int[] POURCENT_TYPE = { 14, 14, 44, 28 };

	public EntrepotMap() {
		put(Wagon.WAGON_RESTO, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE1, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE2, new ArrayList<Wagon>());
		put(Wagon.WAGON_DOUBLE, new ArrayList<Wagon>());

	}

	public EntrepotMap(int nb) {
		fabrique(nb);
		put(Wagon.WAGON_RESTO, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE1, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE2, new ArrayList<Wagon>());
		put(Wagon.WAGON_DOUBLE, new ArrayList<Wagon>());
	}

	public void fabrique(int nbWagon) {
		int nbWagonRestoARajouter = (nbWagon * POURCENT_TYPE[Wagon.WAGON_RESTO]) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			ArrayList<Wagon> lstWagon = get(Wagon.WAGON_RESTO);
			Wagon wagonResto = new WagonResto();
			lstWagon.add(wagonResto);
		}
		int nbWagon1ereARajouter = (nbWagon * POURCENT_TYPE[Wagon.WAGON_SIMPLE1]) / 100;
		nTotal += nbWagon1ereARajouter;
		for (int i = 0; i < nbWagon1ereARajouter; i++) {
			get(Wagon.WAGON_SIMPLE1).add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
		}
		int nbWagon2ereARajouter = (nbWagon * POURCENT_TYPE[Wagon.WAGON_SIMPLE2]) / 100;
		nTotal += nbWagon2ereARajouter;
		for (int i = 0; i < nbWagon2ereARajouter; i++) {
			get(Wagon.WAGON_SIMPLE2).add(new WagonSimple(WagonSimple.SECONDE_CLASSE));
		}
		int nbWagonDoubleARajouter = nbWagon - nTotal;
		for (int i = 0; i < nbWagonDoubleARajouter; i++) {
			get(Wagon.WAGON_DOUBLE).add(new WagonDouble());
		}
	}

	public int trouverLeDernierWagonDuMemeType(int type) { // Ca ne sert plus à rien
		return get(type).size() - 1;
	}

	public boolean add(Wagon e) {
		return get(e.getType()).add(e);
	}

	public void add(int index, Wagon element) {
		get(element.getType()).add(index, element);
	}

	public void permuter1en1(int type, int indice1) {
		this.add(indice1, get(type).remove(indice1 + 1));
	}

	public void tri1() {
		Set<java.util.Map.Entry<Integer, ArrayList<Wagon>>> set = entrySet();
		for (java.util.Map.Entry<Integer, ArrayList<Wagon>> entry : set) {
			ArrayList<Wagon> lst = entry.getValue();
			boolean permuteAuMoinsUneFois = true;
			while (permuteAuMoinsUneFois) {
				permuteAuMoinsUneFois = false;
				for (int i = 0; i < lst.size() - 1; i++) {
					if (lst.get(i).compareTo(lst.get(i + 1)) == 1) {
						permuter1en1(entry.getKey().intValue(), i);
						permuteAuMoinsUneFois = true;
					}
				}
			}
		}
	}

	public Wagon remove(int type, int index) {
		ArrayList<Wagon> lst = get(type);
		return lst.remove(index);
	}

}
