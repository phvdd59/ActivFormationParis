package com.formation.thcr.exo;

import java.util.ArrayList;

import com.formation.phva.exo.InterExoArrayList1;

public class ExoArrayList1 implements InterExoArrayList1 {

	/**
	 * Exemple d=7 , n=5 p=3 --> [7,10,13,16,19]
	 * 
	 * @param d
	 *            = valeur de départ
	 * @param n
	 *            = nb d'élément
	 * @param p
	 *            = pas entre chaque élément
	 * @return = nouveau tableau rempli
	 */
	public ArrayList<Integer> remplirTableau(int d, int n, int p) {
		// protéger pour remplir tableau sur l'overflow, vérifier à priori.
		ArrayList<Integer> list = new ArrayList<Integer>();
		if ((long) d + (long) (p * n) > Integer.MAX_VALUE || (long) d + (long) (p * n) < Integer.MIN_VALUE) {
		} else {
			for (int i = 0; i < n; i++) {
				list.add(d);
				d = d + p;
			}
		}
		return list;

	}

	/**
	 * Exemple tab = [7,10,13,16,19,21,24,27,30] i1=3 , i2=8 tab =
	 * [7,10,27,16,19,21,24,13,30]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param i1
	 *            première position pour l'interversion
	 * @param i2
	 *            deuxième position pour l'interversion
	 * @return
	 */
	public ArrayList<Integer> intervertirDeuxElementsTableau(ArrayList<Integer> tab, int i1, int i2) {
		ArrayList<Integer> tmpTab = null;
		if (i1 > 0 && i1 < tab.size() && i2 > 0 && i2 < tab.size() && tab != null) {
			tmpTab = new ArrayList<Integer>();
			tmpTab.addAll(tab);
			tmpTab.set(i2, tab.get(i1));
			tmpTab.set(i1, tab.get(i2));
		} else {
			return tab;
		}
		return tmpTab;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position après laquelle il faut ajouter la valeur a
	 * @param a
	 *            valeur à ajouter
	 * @return
	 */
	public ArrayList<Integer> insererUnElementDansTableau(ArrayList<Integer> tab, int p, int a) {
		ArrayList<Integer> tmpTab = null;
		if (p >= 0 && p < tab.size() && tab != null) {
			tmpTab = new ArrayList<Integer>();
			tmpTab.addAll(tab);
			tmpTab.add(p, a);
		} else {
			return tab;
		}
		return tmpTab;

	}

	/**
	 * Exemple 1 [1,4,6,2,4,7] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,7] Exemple 2
	 * [22,11,0,77,88,99] : p=2, tab1=[3,4,5,6] --> [22,11,3,4,5,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position où il faut remplacer les valeurs du premier tableau
	 *            par celles du second
	 * @param tab1
	 *            tableau contenant les valeurs de remplacement
	 * @return tableau
	 */
	public ArrayList<Integer> insererUnTableauDansUnAutreAvecRemplacement(ArrayList<Integer> tab, int p,
			ArrayList<Integer> tab1) {
		ArrayList<Integer> tmpTab = new ArrayList<Integer>();
		if (p < 0 || p >= tab.size() || tab == null || tab1 == null) {
			return tab;
		} else {
			if (tab.size() - p > tab1.size()) {
				for (int i = 0; i < p; i++)
					tmpTab.add(i, tab.get(i));
				for (int i = p; i < tab1.size() + p; i++)
					tmpTab.add(i, tab1.get(i - p));
				for (int i = p + tab1.size(); i < tab.size(); i++)
					tmpTab.add(i, tab.get(i));
			} else {
				for (int i = 0; i < tab.size(); i++) {
					if (i < p) {
						tmpTab.add(i, tab.get(i));
					} else {
						tmpTab.add(i, tab1.get(i - p));
					}
				}
			}
		}
		return tmpTab;
	}

	/**
	 * Exemple 1 tab [1,4,6,2,4,6] : p = 2 --> tab résultat [4,6,1,4,6,2]
	 * Exemple 2 tab [1,4,6,2,4,6] : p = 4 --> tab résultat [6,2,4,6,1,4]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position : décaler le tableau vers la droite de p positions et
	 *            les p élements de la fin du tableau reviennent en début de
	 *            tableau
	 * @return
	 */
	public ArrayList<Integer> rotationTableau(ArrayList<Integer> tab, int p) {
		ArrayList<Integer> tmpTab = new ArrayList<Integer>();
		if (tab == null || (tab instanceof ArrayList<?> != true)) {
			return tab;
		}
		if (Math.abs(p) > tab.size() && tab.size() != 0) {
			if (p < 0) {
				p = p % tab.size();
				p = -p;
			} else {
				p = p % tab.size();
			}
		}
		if (p >= 0 && p < tab.size() && tab.size() != 0) {
			tmpTab.addAll(tab);
			for (int i = 0; i < tab.size(); i++) {
				if (i + p < tab.size()) {
					tmpTab.set(i + p, tab.get(i));
				} else {
					tmpTab.set(i + p - tab.size(), tab.get(i));
				}
			}
		} else if (p <= 0 && p < tab.size() && tab.size() != 0) {
			tmpTab.addAll(tab);
			for (int i = 0; i < tab.size(); i++) {
				if (i + p < 0 || i - p < tab.size()) {
					tmpTab.set(i, tab.get(i - p));
				} else {
					tmpTab.set(i, tab.get(i - p - tab.size()));
				}
			}
		}
		return tmpTab;
	}
}