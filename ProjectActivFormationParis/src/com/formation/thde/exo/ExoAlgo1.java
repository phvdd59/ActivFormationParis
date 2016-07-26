package com.formation.thde.exo;

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
	 * 
	 * la solution doit retourner la position d'un point d'equilibre si il
	 * existe. sinon retourner -1
	 */
	public int solution(int[] tab) {
		int equilibre = -1;
		if (tab == null) {
		} else {
			int sommeGauche = 0;
			int sommeDroite = 0;
			for (int i = 0; i < tab.length; i++) {
				sommeGauche = 0;
				sommeDroite = 0;
				if (i != 0) {
					for (int j = 0; j < i; j++) {
						if (sommeGauche + tab[j]>Integer.MAX_VALUE||sommeGauche + tab[j]<Integer.MIN_VALUE){
							//CASSE
						}else{
						sommeGauche += tab[j];
						}
					}
				}
				if (i != tab.length - 1) {
					for (int j = i + 1; j < tab.length; j++) {
						if (sommeDroite + tab[j]>Integer.MAX_VALUE||sommeDroite + tab[j]<Integer.MIN_VALUE){
							//CASSE
						}else{
						sommeDroite += tab[j];
					}
				}
				}
				if (sommeGauche == sommeDroite) {
					equilibre = i;
					break;
				}
			}
		}
		return equilibre;
	}
}