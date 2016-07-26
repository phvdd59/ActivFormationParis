package com.formation.thde.exo;

import com.formation.phva.exo.InterExoTableau2;

public class ExoTableau2 implements InterExoTableau2 {

	/**
	 * Exemple tab = [1,4,6,-5,7,5]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		int[] tab2 = null;
		if (tab == null) {
		} else {
			tab2 = new int[tab.length];
			for (int i = 0; i < tab.length; i++) {
				tab2[i] = tab[tab.length - 1 - i];
			}
		}
		return tab2;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : a=8 --> [1,4,6,2,4,6,8]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param a
	 *            valeur à ajouter à la fin
	 * @return
	 */
	public int[] rallongerTableauDeUnElement(int[] tab, int a) {
		int[] tab2 = null;
		if (tab == null) {
		} else {
			tab2 = new int[tab.length + 1];
			for (int j = 0; j < tab.length; j++) {
				tab2[j] = tab[j];
			}
			tab2[tab2.length - 1] = a;
		}
		return tab2;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,6,2,4,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position où il faut insérer le 2ème tableau
	 * @param tab1
	 *            tableau à insérer
	 * @return tableau
	 */
	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1) {
		int[] tab2 = null;
		int k = 0;
		if (tab == null) {
		} else if (tab1 == null || p < 0 || p > tab.length + 1) {
			tab2 = tab.clone();
		} else {
			tab2 = new int[tab.length + tab1.length];
			for (int j = 0; j < p; j++) {
				tab2[j] = tab[j];
			}
			for (int j = p; j < p + tab1.length; j++) {
				tab2[j] = tab1[k];
				k++;
			}
			for (int j = p + tab1.length; j < tab2.length; j++) {
				tab2[j] = tab[j - tab1.length];
			}
		}
		return tab2;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [] [8,2] [4,6] Exemple 2 [1,7,8,2,4,6]
	 * : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param d
	 *            dimension de base
	 * @return tableau de 2 dimensions avec
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tab2 = null;
		int cpt = 0;
		if (tab == null || d <= 0 || tab.length % d != 0) {
		} else {
			tab2 = new int[tab.length / d][d];
			for (int i = 0; i < tab.length / d; i++) {
				for (int j = 0; j < d; j++) {
					tab2[i][j] = tab[cpt];
					cpt++;
				}
			}
		}
		return tab2;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] tab2 = null;
		//_____CONDITIONS____

		if (v < 0) {
			int nombre = -v - 1;
			int pow = 0;
			while (nombre > (int) Math.pow(2, pow)) {
				pow++;
			}
			pow = pow - 1;
			tab2 = new int[32];
			for (int i = pow; i >= 0; i--) {
				if (nombre % (int) Math.pow(2, i) != nombre) {
					tab2[tab2.length - 1 - i] = 1;
					nombre = nombre % (int) Math.pow(2, i);
				}
			}
			for (int i = 0; i < tab2.length; i++) {
				if (tab2[i] == 0) {
					tab2[i] = 1;
				} else {
					tab2[i] = 0;
				}
			}

		} else {
			int nombre = v;
			int pow = 0;
			while (nombre > (int) Math.pow(2, pow)) {
				pow++;
			}
			pow = pow - 1;
			tab2 = new int[pow + 1];
			for (int i = pow; i >= 0; i--) {
				if (nombre % (int) Math.pow(2, i) != nombre) {
					tab2[tab2.length - 1 - i] = 1;
					nombre = nombre % (int) Math.pow(2, i);
				}
			}
		}
		return tab2;
	}
}