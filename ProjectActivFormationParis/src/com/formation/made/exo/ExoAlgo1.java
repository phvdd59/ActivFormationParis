package com.formation.made.exo;

import com.formation.phva.exo.ImpAlgo1;

public class ExoAlgo1 implements ImpAlgo1 {

	/**
	 * soit p entier tel que : 0 <= p < n tableau tab de n elements
	 * 
	 * la somme des elements des plus petits indice doit etre egal a la somme des elements des plus grand indice
	 * 
	 * la somme d'aucun element est egal a zero (p==0 || p==n-1) exemple
	 * 
	 * n=8 tab=[-1,3,-4,5,1,-6,2,1]
	 * 
	 * p=1 est un point d'equilibre ==> -1 = somme(-4,5,1,-6,2,1) p=3 est un point d'equilibre somme(-1,3,-4) = somme(1,-6,2,1) = -2 p=7 est un point d'equilibre somme(-1,3,-4,5,1,-6,2) = somme() = 0 p=8 n'est pas un point d'equilibre
	 * 
	 * n [0 --> 100000] chaque element du tableau est un int
	 */
	public int solution(int[] tab) {
		int positionEquilibre = -1;
		if (tab != null) {
			int sommegauche = 0;
			int sommedroite = 0;
			int sommepremiereposition = 0;
			int sommederniereposition = 0;
			for (int i = 1; i < tab.length; i++) {
				if (sommepremiereposition + tab[i] > Integer.MIN_VALUE || sommepremiereposition + tab[i] < Integer.MAX_VALUE) {
					sommepremiereposition = sommepremiereposition + tab[i];
				}
			}
			if (sommepremiereposition == 0) {
				positionEquilibre = 0;
			}

			for (int i = 0; i < tab.length - 1; i++) {
				if (sommederniereposition + tab[i] > Integer.MIN_VALUE || sommederniereposition + tab[i] < Integer.MAX_VALUE) {
					sommederniereposition = sommederniereposition + tab[i];
				}
			}
			if (sommederniereposition == 0) {
				positionEquilibre = tab.length - 1;
			}
			for (int p = 1; p <= tab.length - 2; p++) {
				for (int i = 0; i < p; i++) {
					if (sommegauche + tab[i] > Integer.MIN_VALUE || sommegauche + tab[i] < Integer.MAX_VALUE) {

						sommegauche = sommegauche + tab[i];
					} else {
						long sommegauchel = sommegauche;
						sommegauchel = (long) sommegauche + (long) tab[i];
					}

				}
				for (int i = p + 1; i < tab.length; i++) {
					if (sommedroite + tab[i] > Integer.MIN_VALUE || sommedroite + tab[i] < Integer.MAX_VALUE) {
						sommedroite = sommedroite + tab[i];
					}
				}
				if (sommedroite == sommegauche) {
					positionEquilibre = p;
					break;
				}
			}
		}
		return positionEquilibre;
	}

	// tableau est un tableau int un
	// si il n(y a pas de point d'équilibre. renvoyer la valeur -1
	// fournir le 1er point d'équilibre si il existe
	// la solution doit retourner la position d'un point d'équilibre
	// ne pas oublier les controles
	// on ne prend pas la valeur de la position de p!!

	// public int[] retirerElementTableau(int[] tab, int p) {
	// int[] tablereduite = null;
	// tablereduite = new int[tab.length - 1];
	// for (int i = 0; i < p; i++) {
	// tablereduite[i] = tab[i];
	// }
	// for (int i = p; i < tablereduite.length; i++) {
	// tablereduite[i] = tab[i + 1];
	// }
	// for (int i = 0; i < tablereduite.length; i++) {
	// // System.out.println(tablereduite[i]);
	// }
	// return tablereduite;
	// }

}