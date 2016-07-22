package com.formation.soka.exo;

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
		int[] tab = null;
		if ((long) d + (long) p * n > Integer.MAX_VALUE || (long) d + (long) p * n < Integer.MIN_VALUE) {
		} else {
			tab = new int[n];
			for (int i = 0; i < n; i++) {
				tab[i] = d + (i * p);
			}
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
		int[] tab2 = null;
		if (tab == null) {
		} else if (i1 < 0 || i2 < 0 || i1 >= tab.length || i2 >= tab.length) {
			tab2 = tab.clone();
		} else {
			tab2 = tab.clone();
			tab2[i1] = tab[i2];
			tab2[i2] = tab[i1];
		}
		return tab;
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
		int[] newTab = null;
		if (tab == null) {
		} else if (p < 0 || p >= tab.length) {
			newTab = tab.clone();
		} else {
			newTab = new int[tab.length + 1];
			for (int i = 0; i < newTab.length; i++) {
				if (i < p) {
					newTab[i] = tab[i];
				} else if (i == p) {
					newTab[i] = a;
				} else {
					newTab[i] = tab[i - 1];
				}
			}
		}
		return newTab;
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
		if (tab == null || tab1 == null || p >= tab.length || p < 0) {
		}
		for (int i = 0; i < tab.length; i++) {
			if (i >= p && i < p + tab1.length) {
				tab[i] = tab1[i - p];
			}
		}
		return tab;
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
		int[] nuevoTab = null;
		if (tab == null) {
		} else if (p >= tab.length || p < 0) {
			nuevoTab = tab.clone();
		} else {
			nuevoTab = new int[tab.length];
			for (int i = 0; i < tab.length - 1; i++) {
				if (i >= p && i <= tab.length) {
					nuevoTab[i - p] = tab[i];
				} else {
					nuevoTab[nuevoTab.length - p] = tab[i];
				}
			}
		}
		return nuevoTab;
	}
}