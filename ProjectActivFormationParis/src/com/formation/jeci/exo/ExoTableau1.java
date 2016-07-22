package com.formation.jeci.exo;

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
		if (n < 0) {
			tab = null;
		} else if ((long) d + (long) n * (long) p > Integer.MAX_VALUE || (long) d + (long) n * (long) p < Integer.MIN_VALUE) {
			tab = null;
		} else {
			tab = new int[n];

			for (int i = 0; i < tab.length; i++) {

				if (i == 0) {
					tab[i] = d;
				} else {
					tab[i] = d + i * p;
				}

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
		int[] tab1 = null;
		if (i1 <= 0) {
			tab1 = tab;

		} else if (i2 <= 0) {
			tab1 = tab;
		} else if (i1 > tab.length + 1) {
			tab1 = tab;

		} else if (i2 > tab.length + 1) {
			tab1 = tab;

		} else {
			tab1 = tab;
			int a = tab1[i1 - 1];
			tab1[i1 - 1] = tab1[i2 - 1];
			tab1[i2 - 1] = a;
		}
		return tab1;
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
		if (p < 0 || p > tab.length) {
			p = 0;

		}

		int[] tab1 = new int[tab.length + 1];
		for (int i = 0; i < tab1.length; i++) {

			if (i == p) {
				tab1[i] = a;

			} else if (i < p) {
				tab1[i] = tab[i];
			} else {
				tab1[i] = tab[i - 1];
			}
		}

		return tab1;
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
		int[] tab2 = null;

		if (tab == null || tab1 == null) {
			tab2 = null;
		} else if (p < 0 || p > tab.length) {
			tab2 = null;

		} else if (p + tab1.length > tab.length) {
			tab2 = null;
		} else {
			for (int i = 0; i < tab.length; i++) {
				tab2 = new int[tab.length];
				if (i >= p + tab1.length) {
					tab2[i] = tab[i];

				} else if (i < p) {
					tab2[i] = tab[i];
				} else {
					tab2[i] = tab1[i - p];
				}
			}

		}

		return tab2;

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
		int[] tab5 = null;
		int[] tab3 = null;
		int[] tab4 = null;
		int m = 0;
		if (tab == null) {
			tab5 = null;
		} else if (p >= 0) {
			m = p % tab.length;
			tab3 = new int[tab.length - p];
			tab4 = new int[p];
			tab5 = new int[tab.length];
			for (int i = 0; i < tab.length; i++) {

				if (i < tab.length - m) {
					tab4[i] = tab[i];

				} else {
					tab3[i - (tab.length - m)] = tab[i];
				}
			}
			for (int i = 0; i < tab.length; i++) {
				if (i < tab.length - m) {
					tab5[i] = tab3[i];

				} else {
					tab5[i] = tab4[i - (tab.length - m)];
				}

			}
		} else if (p < 0) {
			tab3 = new int[tab.length - p];
			tab4 = new int[p];
			tab5 = new int[tab.length];
			m = -p % tab.length;
			for (int i = 0; i < tab.length; i++) {

				if (i < m) {
					tab4[i] = tab[i];

				} else {
					tab3[i - m] = tab[i];
				}
			}
			for (int i = 0; i < tab.length; i++) {
				if (i < tab.length - m) {
					tab5[i] = tab3[i];

				} else {
					tab5[i] = tab4[i - (tab.length - m)];
				}

			}
		}

		return tab5;
	}
}