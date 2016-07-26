package com.formation.emma.exo;

import com.formation.phva.exo.ImpAlgo1;

public class ExoAlgo1 implements ImpAlgo1 {

	/**
	 * soit p entier tel que : 0 <= p < n tableau tab de n elements
	 * 
	 * la somme des elements des plus petits indice doit etre egal a la somme
	 * des elements des plus grand indice
	 * 
	 * la somme d'aucun element est egal a zero (p==0 || p==n-1) exemple
	 * 
	 * n=8 tab=[-1,3,-4,5,1,-6,2,1]
	 * 
	 * p=1 est un point d'equilibre ==> -1 = somme(-4,5,1,-6,2,1) p=3 est un
	 * point d'equilibre somme(-1,3,-4) = somme(1,-6,2,1) = -2 p=7 est un point
	 * d'equilibre somme(-1,3,-4,5,1,-6,2) = somme() = 0 p=8 n'est pas un point
	 * d'equilibre
	 * 
	 * n [0 --> 100000] chaque element du tableau est un int
	 */

	// donner un point d'equilibre si il existe
	// meme si plusieurs on en donne qu'un
	// si pas de point d'equilibre on renvoi -1

	public int solution(int[] tab) {
		int sommeAvant = 0;
		int sommeApres = 1;
		int k = -1;

		if (tab == null) {

		} else {
			for (int p = 0; p < tab.length; p++) {
				k++;
				if (sommeAvant == sommeApres) {
					break;

				} else {

					if (p == 0) {
						sommeAvant = 0;
						sommeApres = 0;
						for (int i = p + 1; i < tab.length; i++) {

							sommeApres = sommeApres + tab[i];

						}

					} else if (p > 0 && p < tab.length) {
						sommeAvant = 0;
						for (int i = 0; i < p; i++) {

							sommeAvant = sommeAvant + tab[i];
						}
						sommeApres = 0;
						for (int i = p + 1; i < tab.length; i++) {

							sommeApres = sommeApres + tab[i];
						}

					} else if (p == tab.length) {
						sommeApres = 0;
						sommeAvant = 0;
						for (int i = 0; i < tab.length - 1; i++) {

							sommeAvant = sommeAvant + tab[i];

						}

					}
				}
			}
		}

		if (tab == null || k == tab.length - 1 && sommeAvant != sommeApres) {
			k = 0;
		}

		return k - 1;
	}

}