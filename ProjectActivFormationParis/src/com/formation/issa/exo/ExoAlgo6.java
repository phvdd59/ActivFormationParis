package com.formation.issa.exo;

import com.formation.phva.inter.InterAlgo6;

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

		f = 3;
		n = 2;
		int indice = 0;
		int somme1 = 0;
		int somme2 = 0;
		int maxValue = 0;
		int[] tab1 = new int[tab.length];
		int[] tab2 = new int[tab.length];
		if (n > tab.length || f > tab.length || n<0 || f<0 || tab.length == 0) {
			return -1;
		} else {
			for (int i = n; i < tab.length - n; i++) {
				indice = i;
				for (int j = i - 2; j <= i + 2; j++) {
					somme1 = somme1 + tab[j];

				}
				tab1[indice] = somme1;
				somme1 = 0;
			}

			for (int j2 = f; j2 < tab1.length - f; j2++) {
				indice = j2;
				for (int k = j2; k <= j2 + n; k++) {
					somme2 = somme2 + tab1[k];
				}
				tab2[indice] = somme2;
				somme2 = 0;

			}

			for (int i = 0; i < tab2.length; i++) {

				if (maxValue < tab2[i]) {
					maxValue = tab2[i];
					indice = i;
					tab2[indice] = maxValue;
				}
			}

			return indice;
		}
	}
}
