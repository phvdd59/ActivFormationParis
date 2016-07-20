package com.formation.beba.exo;				//en principe, c'est bon

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
		if (n <= 0) {
			n = 1;
		}
		for (int i = 0; i < tab.length; i++) {
			tab[i] = d + i * p;
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
		if (i1 - 1 > tab.length) {
			i1 = tab.length + 1;
		}
		if (i2 - 1 > tab.length) {
			i2 = tab.length + 1;
		}
		int tampon = tab[i1 - 1];
		tab[i1 - 1] = tab[i2 - 1];
		tab[i2 - 1] = tampon;
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
		int tab2[] = new int[tab.length + 1];
		if (p > tab.length || p < 0) {
			p = 0;
		}
		tab2[p + 1] = a;
		for (int i = 0; i < p; i++) {
			tab2[i] = tab[i];
		}
		for (int i = p + 2; i < tab2.length; i++) {
			tab2[i] = tab[i - 1];
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
		if (tab1.length < tab.length) {
			if (p - 1 + tab1.length > tab.length) {
				p = tab.length - tab1.length + 1;
			}
			int j = 0;
			for (int i = p; i < tab1.length; i++) {
				tab[i] = tab1[j];
				j++;
			}
		} else {
			System.out.println("il n'est pas possible d'effectuer leremplacement: taille de tableau non compatibes");
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
		int tab2[] = new int[tab.length];
		if (p > tab.length || p < 0) {
			p = tab.length / 2;
		}
		for (int i = p; i < tab2.length; i++) {
			tab2[i] = tab[i - p];
		}
		for (int i = 0; i < p - 1; i++) {
			tab2[i] = tab[i];
		}
		return tab2;
	}

	@Override
	public String toString() {
		return "ExoTableau1 [tab=" + Arrays.toString(tab) + "]";
	}
}