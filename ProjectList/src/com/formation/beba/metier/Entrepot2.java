package com.formation.beba.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Entrepot2 extends TreeMap<Integer, ArrayList<Wagon>> {

	public Entrepot2() {
		put(TypeWagon.WAGON_RESTO.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE1.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE2.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_DOUBLE.getType(), new ArrayList<Wagon>());
	}

	public Entrepot2(int nb) {
		put(TypeWagon.WAGON_RESTO.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE1.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_SIMPLE2.getType(), new ArrayList<Wagon>());
		put(TypeWagon.WAGON_DOUBLE.getType(), new ArrayList<Wagon>());
		fabrique(nb);
	}

	public void fabrique(int nbWagon) {

		int nbWagonRestoARajouter = (nbWagon * TypeWagon.WAGON_RESTO.getPourCentType()) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			get(TypeWagon.WAGON_RESTO.getType()).add(new WagonResto());

			// Autre méthode
			// ArrayList<Wagon> listWagon=get(Wagon.WAGON_RESTO);
			// Wagon wagonResto=new WagonResto();
			// listWagon.add(wagonResto);
		}
		int nbWagon1ereARajouter = (nbWagon * TypeWagon.WAGON_SIMPLE1.getPourCentType()) / 100;
		nTotal += nbWagon1ereARajouter;
		for (int i = 0; i < nbWagon1ereARajouter; i++) {
			get(TypeWagon.WAGON_SIMPLE1.getType()).add(new WagonSimple(WagonSimple.PREMIERE_CLASSE));
		}
		int nbWagon2ereARajouter = (nbWagon * TypeWagon.WAGON_SIMPLE2.getPourCentType()) / 100;
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

	public void permuter1en1(int indice1, int type) {
		this.add(indice1, get(type).remove(indice1 + 1));
	}

	public void tri1() {
		Set<java.util.Map.Entry<Integer, ArrayList<Wagon>>> set = entrySet();
		// permit de creer liste sequentielle
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

		// autre methode
		// for (int k = 0; k < this.size(); k++) { // size donne le nombre de
		// cle et non le nombre d'elements
		// ArrayList<Wagon> lst=this.get(k);
		// boolean permuteAuMoinsUneFois = true;
		// while (permuteAuMoinsUneFois) {
		// permuteAuMoinsUneFois = false;
		// for (int i = 0; i < lst.size() - 1; i++) {
		// if (lst.get(i).compareTo(lst.get(i + 1)) == 1) {
		// permuter1en1(k,i);
		// permuteAuMoinsUneFois = true;
		// }
		// }
		// }
		// }

	}

	public Wagon remove(int type, int index) {
		ArrayList<Wagon> lst = get(type);
		return lst.remove(index);
	}

}
