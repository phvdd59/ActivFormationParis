package com.formation.ambr.exo;

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
	 * p=1 (i=1) est un point d'equilibre ==> -1 = somme(-4,5,1,-6,2,1) p=3 est
	 * un point d'equilibre somme(-1,3,-4) = somme(1,-6,2,1) = -2 p=7 est un
	 * point d'equilibre somme(-1,3,-4,5,1,-6,2) = somme() = 0 p=8 n'est pas un
	 * point d'equilibre
	 * 
	 * n [0 --> 100000] chaque element du tableau est un int
	 * 
	 * la solution doit retourner la position d'un point d'equilibre si il
	 * existe. sinon retourner -1
	 */

	public int solution(int[] tab) { // solution 5
		int res = -1;
		if (tab == null) {
			return res;
		}
		for (int i = 0; i < tab.length; i++) {

			int sommeAvanti = 0;
			int sommeApresi = 0;

			for (int j = 0; j < i; j++) {
				sommeAvanti += tab[j];
			}

			for (int j = i + 1; j < tab.length; j++) {
				sommeApresi += tab[j];
			}

			if (sommeAvanti == sommeApresi) {
				return i;
			}
		}

		return res;

	}

	public int solution4(int[] tab) {
		//entrainement

		int res = -1;
		int sommeAvanti = 0;
		int sommeApresi = 0;

		for (int i = 0; i < tab.length; i++) {
			if (i == 0) {
				sommeAvanti = 0;
			}
			for (int j = 0; j < i; j++) { // i+1?
				sommeAvanti += tab[i - j];
				sommeApresi += tab[i + 1];
			}
			//for
			if (sommeAvanti == sommeApresi) {
				//result
			}

		}

		return -1;
	}

	public int solution3(int[] tab) {
		int p = 0;
		int sommeAvanti = 0;
		int sommeApresi = 0;
		int[] tabAvanti = new int[p];
		int[] tabApresi = new int[tab.length - (p + 1)];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < i; j++) {
				tabAvanti[j] = tab[j];
				sommeAvanti += tab[j];
			}
			for (int j = i + 1; j < tab.length; j++) {
				tabApresi[j] = tab[j + (i + 1)];
				sommeApresi += tab[j];
			}
			if (sommeAvanti == sommeApresi) {
				p = i;
			}
		}
		return p;
	}

}

//essai 2
//		int p = 0;
//		int[] tabAvantP = new int[p];
//		int[] tabApresP = new int[tab.length - (p + 1)];
//		int sommeAvantP = 0;
//		int sommeApresP = 0;
//		for (int i = 0; i < p; i++) {
//			//regarder avant la position et après
//			tabAvantP[i] = tab[i];
//			sommeAvantP += tabAvantP[i];
//
//		}
//		for (int i = 0; i < tabApresP.length; i++) {
//			tabApresP[i] = tab[i + (p + 1)];
//			sommeApresP += tabApresP[i];
//		}
//		if (sommeAvantP == sommeApresP) {
//			return p;
//		}

//essai 1
//		for (int p = 0; p < tab.length; p++) {
//			//sommeAvant=somme de tout ce qu'il y a avant p;
//			//sommeApres=somme de tout ce qu'il y a après p;
//			for (int i = 0; i < p; i++) {
//				sommeAvantP=tab[i]++;
//			}
//			for (int i = p+1; i < tab.length; i++) {
//				sommeApresP=tab[i]++;
//			}
//			if (sommeAvantP == sommeApresP) {
//				return p;
//			}
//		}
