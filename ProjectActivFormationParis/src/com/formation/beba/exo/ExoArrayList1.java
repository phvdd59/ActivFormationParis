package com.formation.beba.exo;

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
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (((long) d + (long) n * p) > Integer.MAX_VALUE || ((long) d + (long) n * p) < Integer.MIN_VALUE) {
			list = null;
		} else {
			list.add(d);
			for (int i = 1; i < n; i++) {
				list.add(list.get(i - 1) + p);
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
		ArrayList<Integer> list = (ArrayList<Integer>) tab.clone();
		// ArrayList<Integer> list = new ArrayList<Integer>();
		if (i1 > tab.size() || i2 > tab.size() || i1 < 0 || i2 < 0) {
			list = (ArrayList<Integer>) tab.clone();
		} else {
			// list.addAll(tab);
			list.set(i1, tab.get(i2));
			list.set(i2, tab.get(i1));
		}
		return list;
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
		ArrayList<Integer> list = (ArrayList<Integer>) tab.clone();
		// ArrayList<Integer> list = new ArrayList<Integer>();
		if (p > tab.size() || p < 0) {
			list = (ArrayList<Integer>) tab.clone();
		} else {
			// list.addAll(tab);
			list.add(p, a);
		}
		return list;
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
	public ArrayList<Integer> insererUnTableauDansUnAutreAvecRemplacement(ArrayList<Integer> tab, int p, ArrayList<Integer> tab1) {
		ArrayList<Integer> list = (ArrayList<Integer>) tab.clone();
		if (p + tab1.size() > tab.size() || p < 0) {
			list = null;
		} else {
			// list.addAll(tab);
			for (int i = p; i < p + tab1.size(); i++) {
				list.set(i, tab1.get(i - p));
			}
		}
		return list;
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
		// ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list = (ArrayList<Integer>) tab.clone();
		// list.addAll(tab);
		if (p > 0) {
			int d = p % tab.size();
			for (int i = 0; i < d; i++) {
				list.add(list.remove(0));

			}
		}
		if (p < 0) {
			int d = p % tab.size();
			for (int i = 0; i > d; i--) {
				list.add(0, list.remove(list.size() - 1));

			}
		}
		return list;
	}
}