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
	 * d'equilibre si pas de points d'équilibre il faudra renvoyer -1; fournir 1
	 * point d'équilibre. n [0 --> 100000] chaque element du tableau est un int
	 */
	public int solution(int[] tab) {
		int soluce = -1;
		if (tab != null) {
			int n = tab.length;
			if (n > 0) {
				int sPlus = 0;
				for (int i = 1; i < tab.length; i++) {
					if (((long) sPlus + (long) tab[i] < Integer.MAX_VALUE)
							&& ((long) sPlus + (long) tab[i] > Integer.MIN_VALUE)) {
						sPlus += tab[i];
					} else {
						sPlus += (long) tab[i];
					}
				}
				int sMoins = 0;
				if (sPlus == sMoins) {
					soluce = 0;
				}
				if (soluce != 0) {
					for (int p = 1; p < n - 1; p++) {
						sMoins += tab[p - 1];
						sPlus -= tab[p];
						if (sPlus == sMoins) {
							soluce = p;
							break;
						}
					}
					if (soluce == -1) {
						sPlus = 0;
						sMoins += tab[n - 2];
						if (sPlus == sMoins) {
							soluce = n - 1;
						}
					}
				}
			}
		}
		return soluce;
	}

}