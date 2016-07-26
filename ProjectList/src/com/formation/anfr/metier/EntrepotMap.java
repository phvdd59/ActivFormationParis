package com.formation.anfr.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import com.formation.anfr.metier.Wagon;
import com.formation.anfr.metier.WagonDouble;
import com.formation.anfr.metier.WagonResto;
import com.formation.anfr.metier.WagonSimple;
import com.formation.anfr.metier.typeWagon;

public class EntrepotMap extends TreeMap<Integer, ArrayList<Wagon>> {
	private int[] nbTypeWagons;

	public EntrepotMap() {
		ArrayList<Wagon> listWagonResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonDouble = new ArrayList<Wagon>();
		put(typeWagon.WAGON_RESTO.ordinal(), listWagonResto);
		put(typeWagon.WAGON_SIMPLE1.ordinal(), listWagonSimple1);
		put(typeWagon.WAGON_SIMPLE2.ordinal(), listWagonSimple2);
		put(typeWagon.WAGON_DOUBLE.ordinal(), listWagonDouble);

	}

	public EntrepotMap(int nb) {
		ArrayList<Wagon> listWagonResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listWagonDouble = new ArrayList<Wagon>();
		put(typeWagon.WAGON_RESTO.ordinal(), listWagonResto);
		put(typeWagon.WAGON_SIMPLE1.ordinal(), listWagonSimple1);
		put(typeWagon.WAGON_SIMPLE2.ordinal(), listWagonSimple2);
		put(typeWagon.WAGON_DOUBLE.ordinal(), listWagonDouble);
		fabrique(nb);
	}

	public void fabrique(int nbWagon) {
		int nbWagonRestoARajouter = (nbWagon * typeWagon.WAGON_RESTO.getPourcent()) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			ArrayList<Wagon> lstWagon = get(typeWagon.WAGON_RESTO.ordinal());
			Wagon wagonResto = new WagonResto();
			lstWagon.add(wagonResto);
		}
		int nbWagon1ereARajouter = (nbWagon * typeWagon.WAGON_SIMPLE1.getPourcent()) / 100;
		nTotal += nbWagon1ereARajouter;
		for (int i = 0; i < nbWagon1ereARajouter; i++) {
			get(typeWagon.WAGON_SIMPLE1.ordinal()).add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
		}
		int nbWagon2ereARajouter = (nbWagon * typeWagon.WAGON_SIMPLE2.getPourcent()) / 100;
		nTotal += nbWagon2ereARajouter;
		for (int i = 0; i < nbWagon2ereARajouter; i++) {
			get(typeWagon.WAGON_SIMPLE2.ordinal()).add(new WagonSimple(WagonSimple.SECONDE_CLASSE));
		}
		int nbWagonDoubleARajouter = nbWagon - nTotal;
		for (int i = 0; i < nbWagonDoubleARajouter; i++) {
			get(typeWagon.WAGON_DOUBLE.ordinal()).add(new WagonDouble());
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
