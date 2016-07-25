package com.formation.etga.exo;

import java.util.ArrayList;

import com.formation.phva.exo.InterExoArrayList1;

public class ExoArrayList1 implements InterExoArrayList1 {

	/**
	 * Exemple d=7 , n=5 p=3 --> [7,10,13,16,19]
	 * 
	 * @param d
	 *                = valeur de départ
	 * @param n
	 *                = nb d'élément
	 * @param p
	 *                = pas entre chaque élément
	 * @return = nouveau tableau rempli
	 */
	public ArrayList<Integer> remplirTableau(int d, int n, int p) {
		ArrayList<Integer> list = null;
		int lastValue = d + n * p;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		if ((n > 0) && (lastValue > min) && (lastValue < max)) {
			for (int i = 0; i < n; i++) {
				list.add(d + i * p);
			}
		} else {
			list = null;
		}
		return list;
	}

	/**
	 * Exemple tab = [7,10,13,16,19,21,24,27,30] i1=3 , i2=8 tab =
	 * [7,10,27,16,19,21,24,13,30]
	 * 
	 * @param list
	 *                tableau en entrée
	 * @param i1
	 *                première position pour l'interversion
	 * @param i2
	 *                deuxième position pour l'interversion
	 * @return
	 */
	public ArrayList<Integer> intervertirDeuxElementsTableau(ArrayList<Integer> list, int i1, int i2) {
		ArrayList<Integer> listFinal = null;
		listFinal.addAll(list);
		int a = list.get(i1);
		int b = list.get(i2);
		if ((list != null) && (i1 >= 0) && (i2 >= 0) && (i1 < list.size()) && (i2 < list.size())) {
			listFinal.set(i1, b);
			listFinal.set(i2, a);
		} else {
			listFinal = null;
		}
		return listFinal;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param list
	 *                tableau de départ
	 * @param p
	 *                position après laquelle il faut ajouter la valeur a
	 * @param a
	 *                valeur à ajouter
	 * @return
	 */
	public ArrayList<Integer> insererUnElementDansTableau(ArrayList<Integer> list, int p, int a) {
		ArrayList<Integer> listFinal = null;
		if ((list != null) && (p >= 0) && (p < list.size())) {
			listFinal.addAll(list);
			listFinal.add(p, a);
		} else {
			listFinal = null;
		}
		return listFinal;
	}

	/**
	 * Exemple 1 [1,4,6,2,4,7] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,7] Exemple
	 * 2 [22,11,0,77,88,99] : p=2, tab1=[3,4,5,6] --> [22,11,3,4,5,6]
	 * 
	 * @param list
	 *                tableau de départ
	 * @param p
	 *                position où il faut remplacer les valeurs du premier
	 *                tableau par celles du second
	 * @param list1
	 *                tableau contenant les valeurs de remplacement
	 * @return tableau
	 */
	public ArrayList<Integer> insererUnTableauDansUnAutreAvecRemplacement(ArrayList<Integer> list, int p, ArrayList<Integer> list1) {
		ArrayList<Integer> listFinal = null;
		listFinal.addAll(list);
		if ((list != null) && (list1 != null) && (p >= 0) && (list1.size() <= list.size()) && (p <= (list.size() - list1.size()))) {
			int j = 0;
			for (int i = p; i < (p + list1.size()); i++) {
				listFinal.set(i, list1.get(j));
				j++;
			}
		} else {
			listFinal = null;
		}
		return listFinal;
	}

	/**
	 * Exemple 1 tab [1,4,6,2,4,6] : p = 2 --> tab résultat [4,6,1,4,6,2]
	 * Exemple 2 tab [1,4,6,2,4,6] : p = 4 --> tab résultat [6,2,4,6,1,4]
	 * 
	 * @param list
	 *                tableau de départ
	 * @param p
	 *                position : décaler le tableau vers la droite de p
	 *                positions et les p élements de la fin du tableau
	 *                reviennent en début de tableau
	 * @return
	 */
	public ArrayList<Integer> rotationTableau(ArrayList<Integer> list, int p) {
		ArrayList<Integer> listFinal = null;
		listFinal.addAll(list);
		if ((list != null) && (p > listFinal.size())) {
			p = p % listFinal.size();
		}
		if (p >= 0) {
			for (int i = 0; i < listFinal.size(); i++) {
				if (i < p) {
					listFinal.set(i, list.get(list.size() - i - p));
				} else {
					listFinal.set(i, list.get(i - p));
				}
			}
		} else {
			listFinal = null;
		}
		return listFinal;
	}
}