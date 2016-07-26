package com.formation.anfr.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import com.formation.phva.metier.Wagon;
import com.formation.phva.metier.WagonDouble;
import com.formation.phva.metier.WagonResto;
import com.formation.phva.metier.WagonSimple;

public class EntrepotMap extends TreeMap<Integer, ArrayList<Wagon>> {
	private static int[] POURCENT_TYPE = { 14, 14, 44, 28 };

	private int[] nbTypeWagons;

	public EntrepotMap() {
		ArrayList<Wagon> listWagonResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonDouble = new ArrayList<Wagon>();
		put(Wagon.WAGON_RESTO, listWagonResto);
		put(Wagon.WAGON_SIMPLE1, listWagonSimple1);
		put(Wagon.WAGON_SIMPLE2, listWagonSimple2);
		put(Wagon.WAGON_DOUBLE, listWagonDouble);

	}

	public EntrepotMap(int nb) {
		ArrayList<Wagon> listWagonResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonDouble = new ArrayList<Wagon>();
		put(Wagon.WAGON_RESTO, listWagonResto);
		put(Wagon.WAGON_SIMPLE1, listWagonSimple1);
		put(Wagon.WAGON_SIMPLE2, listWagonSimple2);
		put(Wagon.WAGON_DOUBLE, listWagonDouble);
		fabrique(nb);
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

	public Wagon remove(int type,int index) {
		ArrayList<Wagon> lst = this.get(type);
		return lst.remove(index);
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

}
