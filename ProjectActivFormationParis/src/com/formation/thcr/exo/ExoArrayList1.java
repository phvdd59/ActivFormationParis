package com.formation.thcr.exo;

import java.util.ArrayList;

import com.formation.phva.exo.InterExoArrayList1;

public class ExoArrayList1 implements InterExoArrayList1 {

	/**
	 * Exemple d=7 , n=5 p=3 --> [7,10,13,16,19]
	 * 
	 * @param d
	 *            = valeur de d�part
	 * @param n
	 *            = nb d'�l�ment
	 * @param p
	 *            = pas entre chaque �l�ment
	 * @return = nouveau tableau rempli
	 */
	public ArrayList<Integer> remplirTableau(int d, int n, int p) {
		// prot�ger pour remplir tableau sur l'overflow, v�rifier � priori.
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
	 *            tableau en entr�e
	 * @param i1
	 *            premi�re position pour l'interversion
	 * @param i2
	 *            deuxi�me position pour l'interversion
	 * @return
	 */
	public ArrayList<Integer> intervertirDeuxElementsTableau(ArrayList<Integer> tab, int i1, int i2) {
		ArrayList<Integer> tmpTab = new ArrayList<Integer>();
		if (i1 > 0 && i1 < tab.size() && i2 > 0 && i2 < tab.size()) {
			tmpTab.addAll(tab);
			tmpTab.add(i2, tab.get(i1));
		}
		return tmpTab;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position apr�s laquelle il faut ajouter la valeur a
	 * @param a
	 *            valeur � ajouter
	 * @return
	 */
	public ArrayList<Integer> insererUnElementDansTableau(ArrayList<Integer> tab, int p, int a) {
		ArrayList<Integer> tmpTab = new ArrayList<Integer>();
		if (p >= 0 && p < tab.size()) {
			tmpTab.add(p, a);
		}
		return tmpTab;

	}

	/**
	 * Exemple 1 [1,4,6,2,4,7] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,7] Exemple 2
	 * [22,11,0,77,88,99] : p=2, tab1=[3,4,5,6] --> [22,11,3,4,5,6]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position o� il faut remplacer les valeurs du premier tableau
	 *            par celles du second
	 * @param tab1
	 *            tableau contenant les valeurs de remplacement
	 * @return tableau
	 */
	public ArrayList<Integer> insererUnTableauDansUnAutreAvecRemplacement(ArrayList<Integer> tab, int p,
			ArrayList<Integer> tab1) {
		ArrayList<Integer> tmpTab = new ArrayList<Integer>();
		if (p < 0 || p >= tab.size()) {
		} else {
			for (int i = 0; i < tab.size(); i++) {
				if (i < p) {
					tmpTab.add(i, tab.get(i));
				} else {
					tmpTab.add(i, tab1.get(i - p));
				}
			}
		}
		return tmpTab;
	}

	/**
	 * Exemple 1 tab [1,4,6,2,4,6] : p = 2 --> tab r�sultat [4,6,1,4,6,2]
	 * Exemple 2 tab [1,4,6,2,4,6] : p = 4 --> tab r�sultat [6,2,4,6,1,4]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position : d�caler le tableau vers la droite de p positions et
	 *            les p �lements de la fin du tableau reviennent en d�but de
	 *            tableau
	 * @return
	 */
	public ArrayList<Integer> rotationTableau(ArrayList<Integer> tab, int p) {
		ArrayList<Integer> tmpTab = new ArrayList<Integer>();
		if (p < 0 || p >= tab.size()) {
		} else {
			tmpTab.addAll(tab);
			for (int i = 0; i < tab.size(); i++) {
				if (i + p < tab.size()) {
					tmpTab.set(i + p, tab.get(i));
				} else {
					tmpTab.set(i + p - tab.size(), tab.get(i));
				}
			}
		}
		return tmpTab;
	}
}