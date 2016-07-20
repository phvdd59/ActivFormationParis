package com.formation.emma.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1 implements InterExoTableau1 {

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
	public int[] remplirTableau(int d, int n, int p) {
		int[] tableau = new int[n];
		tableau[0] = d;
		int k = 1;
		for (int i = 0; i < n - 1; i++) {
			tableau[k] = tableau[i] + p;
			k++;
		}

		return tableau;
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
	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
		int a = tab[i1];
		tab[i1] = tab[i2];
		tab[i2] = a;

		return tab;
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
	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		int[] tableauFinal = new int[tab.length + 1];

		for (int i = 0; i < tableauFinal.length; i++) {
			if (i < p) {
				tableauFinal[i] = tab[i];
			} else if (i == p) {
				tableauFinal[i] = a;
			} else if (i > p) {
				tableauFinal[i] = tab[i - 1];

			}
		}
		return tableauFinal;
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
	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		int[] tableauFinal = new int[tab.length];

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
		return tableauFinal;
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
	public int[] rotationTableau(int[] tab, int p) {
		int[] tableauFinal = new int[tab.length];
		int k = 0;
		for (int i = 0; i < tableauFinal.length; i++) {
			if (i + p < tab.length) {
				tableauFinal[i + p] = tab[i];
			} else {
				tableauFinal[k] = tab[i];
				k++;
			}

		}

		return tableauFinal;
	}
}