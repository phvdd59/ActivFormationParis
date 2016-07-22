package com.formation.thcr.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1 implements InterExoTableau1 {

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

	public int[] remplirTableau(int d, int n, int p) {
		// protéger pour remplir tableau sur l'overflow, vérifier à priori.
		int[] tab = null;
		if ((long) d + (long) (p * n) <= Integer.MAX_VALUE && (long) d + (long) (p * n) >= Integer.MIN_VALUE) {
			tab = new int[n];
			for (int i = 0; i < tab.length; i++) {
				tab[i] = d;
				d = d + p;
			}
		} else {
			return tab;
		}
		return tab;
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

	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
		int tmpI1 = 0;
		int tmpI2 = 0;
		int[] tab2 = null;
		if (tab == null) {
			return tab2;
		} else if (i1 > 0 && i1 < tab.length && i2 > 0 && i2 < tab.length) {
			tab2 = tab.clone();
			for (int i = 0; i < tab.length; i++) {
				if (i == i1) {
					tmpI1 = tab2[i];
				} else if (i == i2) {
					tmpI2 = tab2[i];
				}
			}
			for (int i = 0; i < tab.length; i++) {
				if (i == i1) {
					tab2[i] = tmpI2;
				} else if (i == i2) {
					tab2[i] = tmpI1;
				}
			}
		}
		return tab2;
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

	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		int[] tmpTab = null;
		if (tab == null || (tab instanceof int[] != true)) {
			return tmpTab;
		} else if (p >= 0 && p < tab.length) {
			tmpTab = new int[tab.length + 1];
			int j = 0;
			for (int i = 0; i < tmpTab.length; i++) {
				if (i != p) {
					tmpTab[i] = tab[j];
					j++;
				} else {
					tmpTab[i] = a;
				}
			}
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

	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		int[] tmpTab = null;
		if (tab == null || tab1 == null || (tab instanceof int[] != true) || (tab1 instanceof int[] != true)) {
			return tmpTab;
		} else if (p >= 0 && p < tab.length) {
			int j = 0;
			tmpTab = new int[tab.length];
			if (tab.length - p > tab1.length) {
				for (int i = 0; i < p; i++) {
					tmpTab[i] = tab[i];
				}
				for (int i = p; j < tab1.length; i++) {
					tmpTab[i] = tab1[j];
					j++;
				}
				for (int i = p + tab1.length; i < tmpTab.length; i++) {
					tmpTab[i] = tab[i];
				}
			} else {
				for (int i = 0; i < tmpTab.length; i++) {
					if (i < p) {
						tmpTab[i] = tab[i];
					} else {
						tmpTab[i] = tab1[j];
						j++;
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

	public int[] rotationTableau(int[] tab, int p) {
		int[] tmpTab = null;
		if (tab == null || (tab instanceof int[] != true)) {
			return tmpTab;
		} else if (p >= 0 && p < tab.length) {
			tmpTab = tab.clone();
			for (int i = 0; i < tab.length; i++) {
				if (i + p < tab.length) {
					tmpTab[i] = tab[i + p];
				} else {
					tmpTab[i] = tab[(i + p) - tab.length];
				}
			}
		} else if (p <= 0 && p < tab.length) {
			tmpTab = tab.clone();
			for (int i = 0; i < tab.length; i++) {
				if (i + p < 0 && i - p < tab.length) {
					tmpTab[i] = tab[i - p];
				} else {
					tmpTab[i] = tab[tab.length + p + i];
				}
			}
		}
		return tmpTab;
	}
}