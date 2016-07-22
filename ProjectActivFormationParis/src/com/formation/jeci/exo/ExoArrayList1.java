package com.formation.jeci.exo;

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
		if ((long) d + (long) n * (long) p > Integer.MAX_VALUE || (long) d + (long) n * (long) p < Integer.MIN_VALUE) {
			list = null;
		} else {
			for (int i = 0; i < n; i++) {

				if (i == 0) {
					list.add(0, d);
				} else {
					list.add(i, d + i * p);
				}

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
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (tab == null) {
			list = null;
		} else if (i2 < 0 || i2 > tab.size() || i1 < 0 || i1 > tab.size()) {
			list = null;
		} else {
			list.addAll(tab);
			list.add(i1, list.remove(i2));
			list.add(i2, list.remove(i1 + 1));
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
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (tab == null) {
			list = null;
		}
		if (p < 0 || p > tab.size()) {
			list = null;
		} else {
			list.addAll(tab);
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
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (tab == null || tab1 == null) {
			list = null;
		} else if (p < 0 || p > tab.size()) {
			list = null;
		} else if (p + tab1.size() > tab.size()) {
			list = null;
		} else {
			list.addAll(tab);
			int t1 = tab.size();
			int t2 = tab1.size();
			for (int i = list.size(); i > p; i--) {
				list.remove(i - (t1 - t2 - p));

			}
			for (int i = 0; i < t2; i++) {
				list.add(i + p - 1, tab1.get(i));
			}
		}

		return list;

	}

	// comm
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
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (tab == null) {
			list = null;
		} else if (p >= 0) {
			int m = p % tab.size();
			for (int i = tab.size() - m; i < tab.size(); i++) {
				list.add(tab.get(i));
			}
			for (int i = 0; i < tab.size() - m; i++) {
				list.add(tab.get(i));
			}

		} else if (p < 0) {

			int m = -p % tab.size();

			for (int i = m; i < tab.size(); i++) {
				list.add(tab.get(i));
			}
			for (int i = 0; i < m; i++) {
				list.add(tab.get(i));
			}
		}

		return list;
	}
}