package com.formation.thde.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class EntrepotMap extends TreeMap<Integer, ArrayList<Wagon>> {
	private static int[] POURCENT_TYPE = { 14, 14, 44, 28 };

	public EntrepotMap() {
		put(TypeWagon.WAGON_RESTO.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE1.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE2.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_DOUBLE.getType(), new ArrayList<Wagon>());
	}

	public EntrepotMap(int nb) {
		put(TypeWagon.WAGON_RESTO.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE1.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE2.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_DOUBLE.getType(), new ArrayList<Wagon>());
		fabrique(nb);
	}

	public void fabrique(int nbWagon) {
		int nbWagonRestoARajouter = (nbWagon * POURCENT_TYPE[TypeWagon.WAGON_RESTO.getType()]) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			ArrayList<Wagon> lstWagon = get(TypeWagon.WAGON_RESTO.getType());
			Wagon wagonResto = new WagonResto();
			lstWagon.add(wagonResto);
		}
		int nbWagon1ereARajouter = (nbWagon * POURCENT_TYPE[TypeWagon.WAGON_SIMPLE1.getType()]) / 100;
		nTotal += nbWagon1ereARajouter;
		for (int i = 0; i < nbWagon1ereARajouter; i++) {
			get(TypeWagon.WAGON_SIMPLE1.getType()).add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
		}
		int nbWagon2ereARajouter = (nbWagon * POURCENT_TYPE[TypeWagon.WAGON_SIMPLE2.getType()]) / 100;
		nTotal += nbWagon2ereARajouter;
		for (int i = 0; i < nbWagon2ereARajouter; i++) {
			get(TypeWagon.WAGON_SIMPLE2.getType()).add(new WagonSimple(WagonSimple.SECONDE_CLASSE));
		}
		int nbWagonDoubleARajouter = nbWagon - nTotal;
		for (int i = 0; i < nbWagonDoubleARajouter; i++) {
			get(TypeWagon.WAGON_DOUBLE.getType()).add(new WagonDouble());
		}
	}

	public int trouverLeDernierWagonDuMemeType(int type) {
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

	public void tri2() {
		tri1();
	}

	public Wagon remove(int type, int index) {
		ArrayList<Wagon> lst = get(type);
		return lst.remove(index);
	}
}
