package com.formation.beba.exo;

import com.formation.phva.exo.ImpAlgo1;

public class ExoAlgo1Bis implements ImpAlgo1 {

	/**
	 * soit p entier tel que : 0 <= p < n tableau tab de n elements
	 * 
	 * la somme des elements des plus petits indice doit etre egal a la somme
	 * des elements des plus grand indice
	 * 
	 * la somme d'aucun element est egal a zero (p==0 || p==n-1) exemple
	 * 
	 * position regarder la somme de chaque coté et si égal 1
	 * 
	 * si pas de point d'équilibre envoyer p==-1
	 * 
	 * n=8 tab=[-1,3,-4,5,1,-6,2,1]
	 * 
	 * p=1 est un point d'equilibre ==> -1 = somme(-4,5,1,-6,2,1) p=3 est un
	 * point d'equilibre somme(-1,3,-4) = somme(1,-6,2,1) = -2 p=7 est un point
	 * d'equilibre somme(-1,3,-4,5,1,-6,2) = somme() = 0 p=8 n'est pas un point
	 * d'equilibre
	 * 
	 * la solution doit retourner la position d'un point d'équilibre s'il existe
	 * sinon -1
	 * 
	 * n [0 --> 100000] chaque element du tableau est un int
	 */
	public int solution(int[] tab) {
		int result = -1;
		int sommeGauche = 0;
		int sommeDroite = 0;
		boolean trouve = false;
		if (tab != null) {
			if (tab.length == 1) {
				result = 0;
			} else {
				for (int i = 1; i < tab.length; i++) {
					sommeDroite += tab[i];
				}
				if (sommeDroite == sommeGauche) {
					result = 0;
					trouve = true;
				}
				if (trouve == false) {
					for (int i = 1; i < tab.length - 1; i++) {
						sommeGauche += tab[i - 1];
						sommeDroite += -tab[i + 1];
						if (sommeGauche == sommeDroite || result == 0) {
							result = i;
							trouve = true;
							break;
						}
					}
				}
			}
			if (trouve == false) {
				sommeDroite = 0;
				sommeGauche += tab[tab.length - 1];
				if (sommeGauche == sommeDroite || result == 0) {
					result = tab.length;
				}
			}

		}
		return result;
	}
}