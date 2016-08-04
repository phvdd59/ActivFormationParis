package com.formation.issa.exo;

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
		if (tab.length < 0) {
			return null;
		}
		int tab1[] = new int[tab.length];
		for (int i = 0; i < tab.length; i++) {
			tab1[i] = tab[tab.length - 1 - i];
		}
		return tab1;
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
		if (tab.length < 0) {
			return null;
		}
		int tabi[] = new int[tab.length + 1];
		for (int i = 0; i < tabi.length - 1; i++) {
			tabi[i] = tab[i];
		}
		for (int i = tabi.length - 1; i < tabi.length; i++) {
			tabi[i] = a;
		}
		return tabi;
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
		if (p < 0 || p > tab.length) {
			return tab;
		}
		int tabF[] = new int[tab.length + tab1.length];
		for (int i = 0; i < p; i++) {
			tabF[i] = tab[i];
		}
		for (int i = p; i < tab1.length + p; i++) {
			tabF[i] = tab1[i - p];
		}
		for (int i = p + tab1.length; i < tabF.length; i++) {
			tabF[i] = tab[i - p - 1];
		}
		return tabF;
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
		if (tab.length <= d || d <= 0 || tab.length % d !=0) {
			return null;
		}else{
		int[][] tabF = new int[tab.length / d][d];
		for (int i = 0; i < tabF.length; i++) {
			for (int j = 0; j < tabF[0].length; j++) {				
				int indiceDeTab = i * tabF[0].length + j;
				tabF[i][j] = tab[indiceDeTab];

			}

		}
		

		return tabF;
		}
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {

		int somme = v;
		int[] tab = new int[4];

		for (int i = tab.length; i >= 0; i--) {
			while (v == (int) (somme + Math.pow(2, i))) {
				tab[i] = 1;
			}
			tab[i] = 0;
		}

		return tab;
	}
}