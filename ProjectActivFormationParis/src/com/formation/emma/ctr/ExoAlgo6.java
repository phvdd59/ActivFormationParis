package com.formation.emma.ctr;

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
		int somme = 0;
		int indice = -1;
		int k = n;
		int max = 0;
		int[] tableau1 = null;
		int[] tableau2 = null;

		if (n < 0 || n > tab.length / 2 || f < 0 || f > tab.length || tab == null) {
		} else {
			tableau1 = new int[tab.length];
			for (int j = k; j < tab.length - n; j++) {
				indice = j;
				for (int i = j - 2; i <= j + 2; i++) {
					somme = somme + tab[i];
				}
				tableau1[indice] = somme;
				somme = 0;
			}

			tableau2 = new int[tab.length];
			for (int i = 0; i < tableau1.length - f + 1; i++) {
				indice = i;
				for (int j = i; j < i + f; j++) {
					somme = somme + tableau1[j];
				}
				tableau2[indice] = somme;
				somme = 0;
			}

			for (int i = 0; i < tableau2.length; i++) {
				if (tableau2[i] > max) {
					max = tableau2[i];
					indice = i;
				}
			}
		}
		return indice;
	}
}
