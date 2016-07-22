package com.formation.issa.exo;

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
	 * @param
	 * @return = nouveau tableau rempli
	 */
	public int[] remplirTableau(int d, int n, int p) {

		if (n < 0) {
			return null;
		}
		int[] tab = new int[n];

		if ((long) d + (long) p * n > Integer.MAX_VALUE || (long) d + (long) p * n < Integer.MIN_VALUE) {

		} else {
			tab = new int[n];
			tab[0] = d;
			for (int i = 1; i < tab.length; i++) {
				tab[i] = tab[i - 1] + p;
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

		if (i1 < 0 || i2 < 0 || i1 >= tab.length || i2 >= tab.length) {
			return tab;
		}

		int[] tab1 = new int[tab.length];
		for (int i = 0; i < tab1.length; i++) {
			if (i == i1) {
				tab1[i1] = tab[i2];
			} else if (i == i2) {
				tab1[i2] = tab[i1];
			} else {
				tab1[i] = tab[i];
			}
		}

		return tab1;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param tabOrigine
	 *            tableau de départ
	 * @param positionOrigine
	 *            position après laquelle il faut ajouter la valeur a
	 * @param valeurOrigine
	 *            valeur à ajouter
	 * @return
	 */
	public int[] insererUnElementDansTableau(int[] tabOrigine, int positionOrigine, int valeurOrigine) {

		if (positionOrigine < 0 || positionOrigine > tabOrigine.length) {
			return tabOrigine;
		}

		int tabResultat[] = new int[tabOrigine.length + 1];

		tabResultat[positionOrigine] = valeurOrigine;

		for (int i = 0; i < positionOrigine; i++) {

			tabResultat[i] = tabOrigine[i];
		}

		for (int i = positionOrigine + 1; i < tabResultat.length; i++) {
			tabResultat[i] = tabOrigine[i - 1];

		}

		return tabResultat;

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

		if (p < 0 || p > tab.length || p + tab1.length > tab.length) {
			return tab;
		}
		if (tab == null || tab1 == null) {
			return tab;
		}

		int[] tabF = new int[tab.length];

		for (int i = 0; i < p; i++) {

			tabF[i] = tab[i];
		}
		for (int j = p; j < tab1.length + p; j++) {
			tabF[j] = tab1[j - p];
		}

		for (int j = p + tab1.length; j < tabF.length; j++) {
			tabF[j] = tab[j];
		}

		return tabF;
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
	public int[] rotationTableau(int[] tabOrigine, int positionOrigine) {

		if (positionOrigine > tabOrigine.length) {
			positionOrigine = tabOrigine.length % positionOrigine;
			}
		
		int[] tabResultat = new int[tabOrigine.length];

		for (int i = 0; i < tabResultat.length; i++) {
			if (i-positionOrigine < 0) {
				tabResultat[i] = tabOrigine[i - positionOrigine + tabResultat.length];
			} else {

				tabResultat[i] = tabOrigine[i - positionOrigine];
			}
		}

		return tabResultat;
	}
}