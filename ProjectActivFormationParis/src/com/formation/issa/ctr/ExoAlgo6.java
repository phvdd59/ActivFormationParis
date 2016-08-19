package com.formation.issa.ctr;

import com.formation.phva.exo.InterAlgo6;

public class ExoAlgo6 implements InterAlgo6 {
	/**
	 * Chronologiquement le nombre de vente est stocké dans un tableau. IKAE
	 * souhaite connaîre la période la plus faste des ventes. Nous avons un
	 * tableau tab constitué d'entiers positifs. Afin de ne pas être affecté par
	 * des valeurs ponctuelles anormales il sera nécessaire de lisser chaque
	 * élement du tableau par ses "n" voisins à gauche et à droite les plus
	 * proches, avant de calculer sur une fenêtre de "f" valeurs correspondantes
	 * à une période celle la plus favorable (ie celle dont la somme la plus
	 * importante). Attention on ne s'intéressera pas aux n premiers éléments et
	 * aux n derniers éléments.
	 * 
	 * example : n=2 f=3 24 27 20 ---------------- ----------------
	 * ---------------- | . | | . | | . | tab = [1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2
	 * ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2 ] . . . . . . 29 28 27 22 19 20 | | | |
	 * ---------- ---------- . . 84 61
	 * 
	 * --> résultat indice : 7 --> valeurs maxi = 84
	 * ([3+7+2+8+9]+[7+2+8+9+2]+[2+8+9+2+6])
	 * 
	 * Donnez le premier indice du tableau "tab" en partant de la gauche
	 * correspondant à la fenêtre "f" la plus favorable avec un lissage de n de
	 * part et d'autre. En cas d'impossibilité renvoyer -1
	 */

	public int solution(int[] tab, int n, int f) {

		n = 2;
		f = 3;

		int[] tab1 = new int[f];
		int[] tab2 = new int[f];
		int[] tab3 = new int[f];
		int j1=0;
		int j2 = 0;
		int indice = tab2[0];

		for (int i = 0; i < tab.length; i++) {
			if(tab.length==0){
				return-1;
			}
			else if (tab.length % 3 != 0) {
				for (int j = 0; j < tab.length; j++) {
					
				
				for (j = 0; j < 2*n+1; j++) {
					j1=j1+tab[j];
				}
				n+=i;
				}
				for (int k = 0; k < tab3.length; k++) {
					
				}
		

				for (int j = 0; j <= 4; j++) {
					tab1[0] = tab1[0] + tab[j];
				}
				for (int j = 7; j <= 11; j++) {
					tab1[1] = tab1[1] + tab[j];

				}
				for (int j = 15; j <= 19; j++) {
					tab1[2] = tab1[2] + tab[j];
				}

				for (j1 = 5; j1 <= 9 + j2; j1++) {

					tab2[j2] = tab2[j2] + tab[j1];

				}
				tab[indice]=tab[5]+j2;
				j2++;

				for (int j = 0; j < tab2.length; j++) {
					indice = indice + tab2[j];
				}

				//for (int j = 13; j < tab.length; j++) {
					//tab3[j3] = tab3[j3] + tab[j];

				//}
				//j3++;
			}
		}

		return indice;
	}
}
