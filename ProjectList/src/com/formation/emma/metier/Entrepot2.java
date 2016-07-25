package com.formation.emma.metier;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Entrepot2 extends TreeMap<Integer, ArrayList<Wagon>> {
	private static int[] POURCENT_TYPE = { 14, 14, 44, 28 };

	public Entrepot2() {
		put(Wagon.WAGON_RESTO, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE1, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE2, new ArrayList<Wagon>());
		put(Wagon.WAGON_DOUBLE, new ArrayList<Wagon>());
	}

	public Entrepot2(int nb) {
		put(Wagon.WAGON_RESTO, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE1, new ArrayList<Wagon>());
		put(Wagon.WAGON_SIMPLE2, new ArrayList<Wagon>());
		put(Wagon.WAGON_DOUBLE, new ArrayList<Wagon>());
		fabrique(nb);
	}

	public void fabrique(int nbWagon) {

		int nbWagonRestoARajouter = (nbWagon * POURCENT_TYPE[Wagon.WAGON_RESTO]) / 100;
		int nTotal = nbWagonRestoARajouter;
		for (int i = 0; i < nbWagonRestoARajouter; i++) {
			get(Wagon.WAGON_RESTO).add(new WagonResto());

			//			Autre m�thode 
			//			ArrayList<Wagon> listWagon=get(Wagon.WAGON_RESTO);
			//			Wagon wagonResto=new WagonResto();
			//			listWagon.add(wagonResto);
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
		//		for (int k = 0; k < this.size(); k++) { // size donne le nombre de cle et non le nombre d'elements
		//		ArrayList<Wagon> lst=this.get(k);
		//			boolean permuteAuMoinsUneFois = true;
		//			while (permuteAuMoinsUneFois) {
		//				permuteAuMoinsUneFois = false;
		//				for (int i = 0; i < lst.size() - 1; i++) {
		//					if (lst.get(i).compareTo(lst.get(i + 1)) == 1) {
		//						permuter1en1(k,i);
		//						permuteAuMoinsUneFois = true;
		//					}
		//				}
		//			}
		//		}

	}

	public Wagon remove(int type, int index) {
		ArrayList<Wagon> lst = get(type);
		return lst.remove(index);
	}

}
