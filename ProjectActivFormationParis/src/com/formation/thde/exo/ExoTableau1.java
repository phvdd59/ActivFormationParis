package com.formation.thde.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1 implements InterExoTableau1 {

	//___________________________________________________

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
		int[] tab = null;
		if (n < 1 || (long) d + (long) p * n > Integer.MAX_VALUE || (long) d + (long) p * n < Integer.MIN_VALUE) {
		} else {
			tab = new int[n];
			tab[0] = d;
			for (int i = 1; i < tab.length; i++) {
				tab[i] = tab[i - 1] + p;
			}
		}
		return tab;
	}
	//___________________________________________________

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
		int[] tab2 = null;
		if (tab == null) {
		} else if (i1 < 0 || i2 < 0 || i1 >= tab.length || i2 >= tab.length) {
			tab2 = tab.clone();
		} else {
			tab2 = tab.clone();
			tab2[i1 - 1] = tab[i2 - 1];
			tab2[i2 - 1] = tab[i1 - 1];
		}
		return tab2;
	}
	//____________________________________________________

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
		int tab2[] = null;
		if (tab == null) {
		} else if (p < 0 || p >= tab.length) {
			tab2 = tab.clone();
		} else {
			tab2 = new int[tab.length + 1];
			for (int i = 0; i < tab2.length; i++) {
				if (i < p) {
					tab2[i] = tab[i];
				} else if (i == p) {
					tab2[i] = a;
				} else {
					tab2[i] = tab[i - 1];
				}
			}
		}
		return tab2;
	}
	//____________________________________________________

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
		int[] tab2 = null;
		if (tab == null) {
		} else if (tab1 == null || p < 0 || p > tab.length - tab1.length || tab1.length > tab.length) {
			tab2 = tab.clone();
		} else {
			int k = 0;
			tab2 = tab.clone();
			for (int i = p; i <= p + tab1.length - 1; i++) {
				tab2[i] = tab1[k];
				k++;
			}
		}
		return tab2;
	}
	//____________________________________________________

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
		int[] tab2 = null;
		int p2 = p;
		if (tab == null) {
		} else {
			if (p < 0) {
				p2 = -p;
				if (p2 >= tab.length) {
					p2 = p2 % tab.length;
				}
				tab2 = new int[tab.length];
				for (int i = 0; i < tab2.length; i++) {
					if (i < tab.length - p2) {
						tab2[i] = tab[i + p2];
					} else {
						tab2[i] = tab[i - (tab2.length - p2)];
					}
				}
			} else {
				if (p2 >= tab.length) {
					p2 = p2 % tab.length;
				}
				tab2 = new int[tab.length];
				for (int i = 0; i < tab2.length; i++) {
					if (i < p2) {
						tab2[i] = tab[i + (tab.length - p2)];
					} else {
						tab2[i] = tab[i - p2];
					}
				}
			}
		}
		return tab2;
	}
}