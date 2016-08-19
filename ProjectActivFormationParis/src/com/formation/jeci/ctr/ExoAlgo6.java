package com.formation.jeci.ctr;

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
	 * ---------------- | . | | . | | . | tab = [1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2 ]
	 *  . . . . . . 29 28 27 22 19 20 | | | |
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
		
		int retour = -1;
		try {
		int[] tab2 = new int[tab.length - (2 * n)];
		int[] tab3 = new int[tab.length - (2 * n) - f];
		int ValeurMaximale = 0;
	
			for (int i = n; i < tab.length - n; i++) {
				for (int j = -n; j <= n; j++) {
					tab2[i - n] += tab[i+j];
				}

			}
			for (int i = 0; i < tab2.length - f; i++) {
				for (int j = 0; j < f; j++) {
					tab3[i] += tab2[i+j];
				}

			}
			for (int i = 0; i < tab3.length; i++) {

				if (tab3[i] > ValeurMaximale) {
					ValeurMaximale = tab3[i];
					
					retour = i+n;
				}
			}

		} catch (Exception e) {
			retour = -1;
		}
		return retour;
	}
}
