package com.formation.beba.exo;

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
		int sommeGauche;
		int sommeDroite;
		for (int i = 0; i < tab.length; i++) {
			sommeGauche = 0;
			sommeDroite = 0;
			if (tab.length == 1) {
				result = 0;
			} else if (i == 0) {
				sommeGauche = 0;
				for (int j = i + 1; j < tab.length; j++) {
					sommeDroite += tab[j];
				}
			} else if (i == tab.length - 1) {
				sommeDroite = 0;
				for (int j = 0; j < i; j++) {
					sommeGauche += tab[j];
				}
			} else {
				for (int j = i + 1; j < tab.length; j++) {
					sommeDroite += tab[j];
				}
				for (int j = 0; j < i; j++) {
					sommeGauche += tab[j];
				}
			}
			if (sommeGauche == sommeDroite) {
				result = i;
				break;
			}
		}

		return result;
	}

}