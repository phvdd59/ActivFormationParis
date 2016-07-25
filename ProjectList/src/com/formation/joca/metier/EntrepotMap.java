package com.formation.joca.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class EntrepotMap extends TreeMap<Integer, ArrayList<Wagon>> {

	private int[] pourcentType;

	public EntrepotMap() {

		pourcentType = new int[4];
		pourcentType[Wagon.WAGON_RESTO] = 14;
		pourcentType[Wagon.WAGON_SIMPLE1] = 14;
		pourcentType[Wagon.WAGON_SIMPLE2] = 44;

		ArrayList<Wagon> listResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listDouble = new ArrayList<Wagon>();
		this.put(Wagon.WAGON_RESTO, listResto);
		this.put(Wagon.WAGON_SIMPLE1, listSimple1);
		this.put(Wagon.WAGON_SIMPLE2, listSimple2);
		this.put(Wagon.WAGON_DOUBLE, listDouble);
	}

	public EntrepotMap(int nbWagon) {
		pourcentType = new int[4];
		pourcentType[Wagon.WAGON_RESTO] = 14;
		pourcentType[Wagon.WAGON_SIMPLE1] = 14;
		pourcentType[Wagon.WAGON_SIMPLE2] = 44;

		ArrayList<Wagon> listResto = new ArrayList<Wagon>();
		ArrayList<Wagon> listSimple1 = new ArrayList<Wagon>();
		ArrayList<Wagon> listSimple2 = new ArrayList<Wagon>();
		ArrayList<Wagon> listDouble = new ArrayList<Wagon>();
		this.put(Wagon.WAGON_RESTO, listResto);
		this.put(Wagon.WAGON_SIMPLE1, listSimple1);
		this.put(Wagon.WAGON_SIMPLE2, listSimple2);
		this.put(Wagon.WAGON_DOUBLE, listDouble);
		this.fabrique(nbWagon);

	}

	public void fabrique(int nbWagon) {
		int nbWagonRestoARajouter = (nbWagon * pourcentType[Wagon.WAGON_RESTO]) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			this.ajouterWagonResto();
		}
		int nbWagon1ereARajouter = (nbWagon * pourcentType[Wagon.WAGON_SIMPLE1]) / 100;
		nTotal += nbWagon1ereARajouter;
		for (int i = 0; i < nbWagon1ereARajouter; i++) {
			this.ajouterWagonSimple1();
		}
		int nbWagon2ereARajouter = (nbWagon * pourcentType[Wagon.WAGON_SIMPLE2]) / 100;
		nTotal += nbWagon2ereARajouter;
		for (int i = 0; i < nbWagon2ereARajouter; i++) {
			this.ajouterWagonSimple2();
		}
		int nbWagonDoubleARajouter = nbWagon - nTotal;
		for (int i = 0; i < nbWagonDoubleARajouter; i++) {
			this.ajouterWagonDouble();
		}
	}

	public void ajouterWagonResto() {
		this.get(Wagon.WAGON_RESTO).add(new WagonResto());
	}

	public void ajouterWagonSimple1() {
		this.get(Wagon.WAGON_SIMPLE1).add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
	}

	public void ajouterWagonSimple2() {
		this.get(Wagon.WAGON_SIMPLE2).add(new WagonSimple(WagonSimple.SECONDE_CLASSE));
	}

	public void ajouterWagonDouble() {
		this.get(Wagon.WAGON_DOUBLE).add(new WagonDouble());
	}

	public boolean add(Wagon e) {
		return this.get(e.getType()).add(e);

	}

	public void add(int index, Wagon e) {
		this.get(e.getType()).add(index, e);

	}

	public void permuter1en1(int type, int indice1) {
		add(indice1, get(type).remove(indice1 + 1));
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
		ArrayList<Wagon> lst = this.get(type);
		return lst.remove(index);
	}

}
