package com.formation.beba.exo; //en principe, c'est bon

import java.util.Arrays;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1 implements InterExoTableau1 {
	int tab[];

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
		int tab[] = new int[n];
		if (n <= 0) { // la taille du tableau doit forcément etre supérieur ou
						// égal à 1
			tab = null;
		}
		if (((long) d + (long) n * p) > Integer.MAX_VALUE || ((long) d + (long) n * p) < Integer.MIN_VALUE) {
			tab = null;
		} else {
			for (int i = 0; i < tab.length; i++) {
				tab[i] = d + i * p;
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
		int[] tabT = tab.clone();
		if (i1 > tab.length - 1 || i2 > tab.length - 1) {
			// les interversions doivent appartenir au
			// tableau
			tab = null;
		} else if (i1 < 0 || i2 < 0) {
			tab = null;
		} else {

			tabT[i1] = tab[i2];
			tabT[i2] = tab[i1];
		}
		return tabT;
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
		int tab2[];
		if (p > tab.length || p < 0) { // l'insetion doit avoir lieu dans le
			tab2 = null; // tableau
		} else {
			tab2 = new int[tab.length + 1];
			tab2[p] = a;
			for (int i = 0; i < p; i++) {
				tab2[i] = tab[i];
			}
			for (int i = p + 1; i < tab2.length; i++) {
				tab2[i] = tab[i - 1];
			}
		}
		return tab2;
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
		int[] tabT;
		if (tab1.length > tab.length || tab1.length + p > tab.length || p < 0) {
			tabT = null;
		} else {
			tabT = tab.clone();

			for (int i = 0; i < tab1.length; i++) {
				tabT[i + p] = tab1[i];
			}

		}
		return tabT;
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
		int[] tab2 = new int[tab.length];
		if (p > tab.length || -p > tab.length) {
			p = p % tab.length;
		}
		if (p < 0) {
			p = tab.length + p;
		}

		for (int i = 0; i < tab.length; i++) {
			if (i < p) {
				tab2[i] = tab[i + tab.length - p];
				// test
			}
			if (i >= p) {
				tab2[i] = tab[i - p];

			}

		}

		return tab2;

	}

	@Override
	public String toString() {
		return "ExoTableau1 [tab=" + Arrays.toString(tab) + "]";
	}
}