package com.formation.anfr.exo;

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
	 * d'equilibre si pas de points d'�quilibre il faudra renvoyer -1; fournir 1
	 * point d'�quilibre. n [0 --> 100000] chaque element du tableau est un int
	 */
	public int solution(int[] tab) {
		int soluce = -1;
		int sPlus = 0;
		int sMoins = 0;
		int n= tab.length;
		if ((n < 100000) && (tab != null)){
			if (n == 1) {
				soluce = 0;
			} else {
				for (int p = 0; p < n; p++) {
					sPlus = SommePlus(tab, p);
					sMoins = SommeMoins(tab, p);
					if (sPlus == sMoins) {
						soluce = p;
						break;
					}
				}
			}
		}
		return soluce;
	}

	public int SommeMoins(int[] tab, int p) {
		int somme = 0;
		if (p != 0) {
			for (int i = 0; i < p; i++) {
				somme += tab[i];
			}
		}
		return somme;
	}

	public int SommePlus(int[] tab, int p) {
		int somme = 0;
		if (p != tab.length - 1) {
			for (int i = p + 1; i < tab.length ; i++) {
				somme += tab[i];
			}
		}
		return somme;
	}


}