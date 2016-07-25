package com.formation.joca.metier;

import java.util.ArrayList;
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
		this.get(0).add(new WagonResto());
	}

	public void ajouterWagonSimple1() {
		this.get(1).add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
	}

	public void ajouterWagonSimple2() {
		this.get(2).add(new WagonSimple(WagonSimple.SECONDE_CLASSE));
	}

	public void ajouterWagonDouble() {
		this.get(3).add(new WagonDouble());
	}

}
