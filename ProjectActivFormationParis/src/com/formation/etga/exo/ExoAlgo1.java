package com.formation.etga.exo;

import com.formation.phva.exo.ImpAlgo1;

public class ExoAlgo1 implements ImpAlgo1 {

	/**
	 * soit p entier tel que : 0 <= p < n tableau tab de n elements
	 * 
	 * la somme des elements des plus petits indice doit etre egal a la
	 * somme des elements des plus grand indice
	 * 
	 * la somme d'aucun element est egal a zero (p==0 || p==n-1) exemple
	 * 
	 * n=8 tab=[-1,3,-4,5,1,-6,2,1]
	 * 
	 * p=1 est un point d'equilibre ==> -1 = somme(-4,5,1,-6,2,1) p=3 est un
	 * point d'equilibre somme(-1,3,-4) = somme(1,-6,2,1) = -2 p=7 est un
	 * point d'equilibre somme(-1,3,-4,5,1,-6,2) = somme() = 0 p=8 n'est pas
	 * un point d'equilibre
	 * 
	 * n [0 --> 100000] chaque element du tableau est un int
	 * 
	 * la solution doit retourner la position d'un point d'equilibre si il
	 * existe. sinon retourner -1
	 */

	public int solution(int[] tab) {
		int result = -1;
		int sum1 = 0;
		int sum2 = 0;
		int gauche = 0;
		int droite = 0;

		if (tab.length == 1) {
			result = 0;
		} else {
			if (tab != null) {
				for (int p = 0; p < tab.length; p++) {
					if (p == 0) {
						for (int i = 1; i < tab.length; i++) {
							sum1 += tab[i];
						}
						if (sum1 == 0) {
							result = p;
							break;
						}
					} else if ((0 < p) && (p < (tab.length - 1))) {
						for (int i = 0; i < p; i++) {
							gauche += tab[i];
						}
						for (int i = p + 1; i < tab.length; i++) {
							droite += tab[i];
						}
						if (gauche == droite) {
							result = p;
							break;
						}
					} else {
						for (int i = 0; i < (tab.length - 1); i++) {
							sum2 += tab[i];
						}
						if (sum2 == 0) {
							result = p;
						}
					}
				}
			}
		}
		return result;
	}
}