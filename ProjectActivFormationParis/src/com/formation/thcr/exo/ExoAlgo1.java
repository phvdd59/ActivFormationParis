package com.formation.thcr.exo;

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
	 * la solution doit retourner la posisition d'un point d'équilibre ou
	 * retourner -1 sinon
	 */
	public int solution(int[] tab) {
		int sol = -1;
		if (tab == null) {
		} else {
			for (int p = 0; p < tab.length; p++) {
				if (p == 0) {
					int sum = 0;
					for (int i = 1; i < tab.length; i++) {
						sum += tab[i];
					}
					if (sum == 0) {
						sol = p;
						break;
					}
				} else if (p == tab.length - 1) {
					int sum = 0;
					for (int i = 0; i < tab.length - 1; i++) {
						sum += tab[i];
					}
					if (sum == 0) {
						sol = p;
						break;
					}
				} else {
					int sumLeft = 0;
					int sumRigth = 0;
					for (int i = 0; i < p; i++) {
						sumLeft += tab[i];
					}
					for (int i = p + 1; i < tab.length; i++) {
						sumRigth += tab[i];
					}
					if (sumLeft == sumRigth) {
						sol = p;
						break;
					}
				}
			}
		}
		return sol;
	}

	public ArrayList<Integer> solution2(int[] tab) {
		ArrayList<Integer> solList = new ArrayList<Integer>();
		for (int p = 0; p < tab.length; p++) {
			if (p == 0) {
				int sum = 0;
				for (int i = 1; i < tab.length; i++) {
					sum += tab[i];
				}
				if (sum == 0) {
					solList.add(p);
				}
			} else if (p == tab.length - 1) {
				int sum = 0;
				for (int i = 0; i < tab.length - 1; i++) {
					sum += tab[i];
				}
				if (sum == 0) {
					solList.add(p);
				}
			} else {
				int sumLeft = 0;
				int sumRigth = 0;
				for (int i = 0; i < p; i++) {
					sumLeft += tab[i];
				}
				for (int i = p + 1; i < tab.length; i++) {
					sumRigth += tab[i];
				}
				if (sumLeft == sumRigth) {
					solList.add(p);
				}
			}

		}
		return solList;
	}

}