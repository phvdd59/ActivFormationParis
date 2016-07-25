package com.formation.issa.exo;

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
	 * @param tablist
	 * @return
	 */
	public ArrayList<Integer> remplirTableau(int d, int n, int p) {

		if (n < 0) {
			return null;
		}

		ArrayList<Integer> tablist = new ArrayList<Integer>();

		if ((long) d + (long) p * n > Integer.MAX_VALUE || (long) d + (long) p * n < Integer.MIN_VALUE) {

		} else {

			tablist.add(d);
			// tablist.add(Integer.valueOf(d));

			for (int i = 0; i < n; i++) {
				tablist.add(tablist.get(i) + p);

			}
		}
		return tablist;

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

		if (i1 < 0 || i2 < 0 || i1 >= tab.size() || i2 >= tab.size()) {
			return tab;
		}
		ArrayList<Integer> tabi = new ArrayList<Integer>();

		for (int i = 0; i < tab.size(); i++) {
			if (i == i1) {
				tabi.add(tab.get(i2));

			} else if (i == i2) {
				tabi.add(tab.get(i1));
			} else {
				tabi.add(tab.get(i));
			}
		}

		return tabi;
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
		if (p < 0 || p > tab.size()) {
			return tab;
		}
		ArrayList<Integer> listeResultat = new ArrayList<Integer>();
		

		

		for (int i = 0; i < p; i++) {

			listeResultat.add(tab.get(i));
			;
		}
		for (int i = p; i < p+1; i++) {
			listeResultat.add(a);
		}

		for (int i = p + 1; i < tab.size()+1; i++) {
			listeResultat.add(tab.get(i-1));

		}

		return listeResultat;

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

		if (p < 0 || p > tab.size() || p + tab1.size() > tab.size()) {
			return tab;
		}
		if (tab == null || tab1 == null) {
			return tab;
		}
		ArrayList<Integer> listeFin = new ArrayList<Integer>();

		int[] tabF = new int[tab.size()];

		for (int i = 0; i < p; i++) {

			listeFin.add(i, tabF[i]);
		}
		for (int j = p; j < tab1.size() + p; j++) {
			listeFin.add(j - p, tabF[j - p]);
		}

		for (int j = p + tab1.size(); j < tabF.length; j++) {
			listeFin.add(j, tabF[j]);

		}

		return listeFin;
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
		return null;
	}
}