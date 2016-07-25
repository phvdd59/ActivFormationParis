package com.formation.jeci.exo;

import java.util.ArrayList;

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
//		ArrayList<Integer> listp = new ArrayList<Integer>();
		int p = -1;

		if (tab != null) {

			int a = 0;
			int b = 0;
//			boolean c = false;

			for (int i = 0; i < tab.length; i++) {
				a = 0;
				b = 0;
				for (int j = i + 1; j < tab.length; j++) {
					a += tab[j];
				}
				for (int j = i - 1; j >= 0; j--) {
					b += tab[j];
				}
				if (a == b) {
					p = i;
//					c = true;
//					listp.add(p);
				break;
				}
			}
//			if (c == false) {
//				listp.add(p);
//
//			}

		}
		return p;
	}

}