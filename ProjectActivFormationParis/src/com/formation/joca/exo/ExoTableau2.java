package com.formation.joca.exo;

import com.formation.phva.exo.InterExoTableau2;;

public class ExoTableau2 implements InterExoTableau2 {

	/**
	 * Exemple tab = [1,4,6,-5,7,5]
	 * 
	 * @param tab
	 *            tableau en entr�e
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		if (tab != null) {
			int[] tabModif = new int[tab.length];
			for (int i = 0; i < tab.length; i++) {
				tabModif[i] = tab[tab.length - 1 - i];
			}
			for (int i = 0; i < tab.length; i++) {
				tab[i] = tabModif[i];
			}
		}
		return tab;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : a=8 --> [1,4,6,2,4,6,8]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param a
	 *            valeur � ajouter � la fin
	 * @return
	 */
	public int[] rallongerTableauDeUnElement(int[] tab, int a) {
		return null;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,6,2,4,6]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position o� il faut ins�rer le 2�me tableau
	 * @param tab1
	 *            tableau � ins�rer
	 * @return tableau
	 */
	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1) {
		return null;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entr�e
	 * @param d
	 *            dimension de base
	 * @return tableau de n dimensions de base
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		return null;
	}

	/**
	 * Exemple v=18 --> r�sultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entr�e
	 * @return tableau repr�sentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		return null;
	}
}