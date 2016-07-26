package com.formation.ambr.exo;

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
		//protections
		if (tab == null) {
			return tab.clone();
		}
		//fin protections
		int[] tab2 = new int[tab.length];
		for (int i = 0; i < tab.length; i++) {
			tab2[i] = tab[(tab.length - 1) - i];
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
		//protections
		if (tab == null) {
			return tab.clone();
		}
		//fin protections
		int[] tab2 = new int[tab.length + 1];
		for (int i = 0; i <= tab.length; i++) {
			if (i == tab.length) {
				tab2[i] = a;
			} else {
				tab2[i] = tab[i];
			}
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
		//protections
		if (p < 0 || p >= tab.length) {
			return tab.clone();
		} else {
			if (tab1.length > tab.length - p) {
				return tab.clone();
			}
		}
		//fin protections
		int[] tabInser = new int[tab.length + tab1.length];
		for (int i = 0; i < p; i++) {
			tabInser[i] = tab[i];
		}
		for (int i = p; i < p + tab1.length; i++) {
			tabInser[i] = tab1[i - p];
		}
		for (int i = p + tab1.length; i < tabInser.length; i++) {
			tabInser[i] = tab[i - (p + 1)];
		}
		return tabInser;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param d
	 *            : nb d'element de la 1ere dimension
	 * @return tableau de 2 dimensions
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tabDim = new int[tab.length / d][d];
		for (int i = 0; i < tabDim.length; i++) {
			for (int j = 0; j < tabDim[0].length; j++) {
				int indiceDeTab = i * tabDim[0].length + j;
				tabDim[i][j] = tab[indiceDeTab];
			}
		}
		return tabDim;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] tab = new int[32];
		for (int i = tab.length - 1; i >= 0; i--) {
			// on ne remplit pas le tableau avec des 1 si v est plus petit que la puissance de 2
			if (v < Math.pow(2, i)) {
				tab[i] = 0;
				// checker si v est divisible par 2 puissance x en partant de la gauche i.e. 2^31
			}
			if (v < Math.pow(2, i) && v > Math.pow(2, i - 1)) {
				tab[i] = 1;

			}
		}
		return null;
	}
}