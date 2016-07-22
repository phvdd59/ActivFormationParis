package com.formation.emma.exo;

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

	//	Remplir tableau conditions validées
	public int[] remplirTableau(int d, int n, int p) {
		int[] tableau = null;

		int k = 1;
		if ((long) d + (long) n * p > Integer.MAX_VALUE || (long) d + (long) n * p < Integer.MIN_VALUE) { // valeur max et min de int
		} else {
			tableau = new int[n];
			tableau[0] = d;
			for (int i = 0; i < n - 1; i++) {
				tableau[k] = tableau[i] + p;
				k++;
			}
		}

		return tableau;
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

	//	Remplir tableau conditions validées
	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
		// ne doit pas changer les valeurs du tableau initial, prend un nouveau tableau
		// avant de cloner on construit un tableau null
		int[] tab2 = null;
		if (i1 < 0 || i1 > tab.length || i2 < 0 || i2 > tab.length || tab == null) {
		} else {
			tab2 = tab.clone();
			int a = tab2[i1];
			tab2[i1] = tab2[i2];
			tab2[i2] = a;
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

	//	Remplir tableau conditions validées
	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		int[] tableauFinal = null;

		if (p < 0 || p > tab.length || tab == null) {
		} else {
			tableauFinal = new int[tab.length + 1];
			for (int i = 0; i < tableauFinal.length; i++) {
				if (i < p) {
					tableauFinal[i] = tab[i];
				} else if (i == p) {
					tableauFinal[i] = a;
				} else if (i > p) {
					tableauFinal[i] = tab[i - 1];

				}
			}
		}
		return tableauFinal;
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

	//	Remplir tableau conditions validées
	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		int[] tableauFinal = null;

		if (tab1 == null || tab == null || p < 0 || p > tab.length || p - 1 + tab1.length >= tab.length) {
		} else {
			tableauFinal = new int[tab.length];

			for (int i = 0; i < tableauFinal.length; i++) {
				if (i < p) {
					tableauFinal[i] = tab[i];
				} else if (i == p) {

					for (int j = 0; j < tab1.length; j++) {
						tableauFinal[i] = tab1[j];
						i++;
					}
					i--;
				} else if (i > p) {

					tableauFinal[i] = tab[i];

				}
			}
		}
		return tableauFinal;
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

	//	Remplir tableau conditions validées
	public int[] rotationTableau(int[] tab, int p) {
		int k = 0;
		int[] tableauFinal = null;
		if (p < 0 || p > tab.length || tab == null) {
		} else {
			tableauFinal = new int[tab.length];

			for (int i = 0; i < tableauFinal.length; i++) {
				if (i + p < tab.length) {
					tableauFinal[i + p] = tab[i];
				} else {
					tableauFinal[k] = tab[i];
					k++;
				}

			}

		}
		return tableauFinal;
	}
}