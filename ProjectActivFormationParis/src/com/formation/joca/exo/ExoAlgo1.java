package com.formation.joca.exo;

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

	//cet algo fait toutes les itérations et renvoit le dernier point d'équlibre calculé
	//il renvoit -1 s'il n'y a pas de point d'équilibre
	public int solution(int[] tab) {

		int result = -1;
		for (int j = 0; j < tab.length; j++) {
			int somme1 = 0;
			int somme2 = 0;
			if (j == 0) {
				for (int i = 1; i < tab.length; i++) {
					somme2 += tab[i];
				}

			} else if (j == tab.length - 1) {
				for (int i = 0; i < tab.length - 1; i++) {
					somme1 += tab[i];
				}

			} else {
				for (int i = 0; i < j; i++) {
					somme1 += tab[i];
				}
				for (int i = j + 1; i < tab.length; i++) {
					somme2 += tab[i];
				}
			}
			if (somme1 == somme2) {
				result = j;
			}
		}
		return result;
	}

	//cet algo s'arrete une fois un point d'équilibre trouvé et renvoit par conséquent le premier point d'équilibre
	//il renvoit -1 s'il n'y a pas de point d'équilibre
	
	/*public int solution(int[] tab) {

		int result = -1;
		int j = 0;
		boolean trouve = false;
		while (j < tab.length && trouve == false) {
			int somme1 = 0;
			int somme2 = 0;
			if (j == 0) {
				for (int i = 1; i < tab.length; i++) {
					somme2 += tab[i];
				}

			} else if (j == tab.length - 1) {
				for (int i = 0; i < tab.length - 1; i++) {
					somme1 += tab[i];
				}

			} else {
				for (int i = 0; i < j; i++) {
					somme1 += tab[i];
				}
				for (int i = j + 1; i < tab.length; i++) {
					somme2 += tab[i];
				}
			}
			if (somme1 == somme2) {
				result = j;
				trouve = true;
			}
			j++;
		}
		return result;
	}*/

}