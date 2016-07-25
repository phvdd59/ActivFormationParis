package com.formation.issa.exo;

import com.formation.phva.exo.ImpAlgo1;

public class ExoAlgo1 implements ImpAlgo1 {

	/**
	 * soit p entier tel que : 0 <= p < n tableau tab de n elements valeur p est
	 * un point d'équilibre si la somme des chiffres avant est égale à la somme
	 * des chiffres après fournir un point d'équilibre s'il existe sinon
	 * retourner -1 la solution doit retourner la position d'un point d'équlibre
	 * s'il existe sinon retourner -1
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
	 * @param sommeTab1
	 */

	public int solution(int[] tab, int p) {
		
		if (p<0 || p>tab.length || tab.length<0){
			return -1;
		}

		int tab1[] = new int[tab.length];
		int somme1 = 0;
		int somme2 = 0;
		for (int i = 0; i < tab1.length; i++) {
			tab1[i] = tab[i];
		}
		for (int i = 0; i < p; i++) {
			somme1 = somme1 + tab1[i];
		}
		
		for (int i = p+1; i < tab1.length; i++) {
			somme2 = somme2 + tab1[i];
		}

		
		if (somme1 == somme2) {
			System.out.println(tab1+" avec une position d'équilibre p= "+p+" et une somme de "+somme2);

		}else{
			System.out.println(-1);
		}
		
		return p;
	}

	@Override
	public int solution(int[] tab) {
		// TODO Auto-generated method stub
		return 0;
	}

}