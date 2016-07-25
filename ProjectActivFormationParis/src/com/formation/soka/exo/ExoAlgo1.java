package com.formation.soka.exo;

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
		int position = -1;
		for (int i = 0; i < tab.length; i++) {
			int somme = 0;
			int somme1 = 0;
			for (int j = 0; j < i; j++) {
				somme += tab[j];
			}
			for (int k = i + 1; k < tab.length; k++) {
				somme1 += tab[k];
			}
			if (somme == somme1) {
				position = i;
				break;
			}

		}
		return position;
	}

//	public int solution2(int[] tab) {
//		
//		int somme1 = 0;
//		int somme2 = 0;
//		for (int i = 0; i < tab.length; i++) {
//			somme1 += tab[i];
//		}
//		for (int i = 0; i < tab.length; i++) {
//			if (i != 0) {
//				somme2 += tab[i - 1];
//				somme1 -= tab[i];
//			}
//			if (somme1 == somme2) {
//				return i;
//			}
//		}
//
//		return -1;
//
//	}
//	
//
//	public int solution3(int[] tab) {
//		int p;
//		for (p = 0; p < tab.length; p++) {
//			int somme = 0;
//			int somme1 = 0;
//			for (int i = 0; i < tab.length;i++) {
//				if (i < p) {
//					for (int j = 0; j < p; j++) {
//						somme += tab[j];
//					}
//				}
//				if (i > p) {
//					for (int j = p + 1; j < tab.length; j++) {
//						somme1 += tab[j];
//					}
//				}
//				break;
//
//			}
//			if (somme != somme1) {
//				p = -1;
//			}
//
//		}
//		return p;
//	}
}