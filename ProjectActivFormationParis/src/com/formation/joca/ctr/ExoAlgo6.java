package com.formation.joca.ctr;

import com.formation.phva.exo.InterAlgo6;

public class ExoAlgo6 implements InterAlgo6 {
	/**
	 * Chronologiquement le nombre de vente est stock� dans un tableau. IKAE
	 * souhaite conna�re la p�riode la plus faste des ventes. Nous avons un
	 * tableau tab constitu� d'entiers positifs. Afin de ne pas �tre affect� par
	 * des valeurs ponctuelles anormales il sera n�cessaire de lisser chaque
	 * �lement du tableau par ses "n" voisins � gauche et � droite les plus
	 * proches, avant de calculer sur une fen�tre de "f" valeurs correspondantes
	 * � une p�riode celle la plus favorable (ie celle dont la somme la plus
	 * importante). Attention on ne s'int�ressera pas aux n premiers �l�ments et
	 * aux n derniers �l�ments.
	 * 
	 * example : n=2 f=3 24 27 20 ---------------- ----------------
	 * ---------------- | . | | . | | . | tab = [1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2
	 * ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2 ] . . . . . . 29 28 27 22 19 20 | | | |
	 * ---------- ---------- . . 84 61
	 * 
	 * --> r�sultat indice : 7 --> valeurs maxi = 84
	 * ([3+7+2+8+9]+[7+2+8+9+2]+[2+8+9+2+6])
	 * 
	 * Donnez le premier indice du tableau "tab" en partant de la gauche
	 * correspondant � la fen�tre "f" la plus favorable avec un lissage de n de
	 * part et d'autre. En cas d'impossibilit� renvoyer -1
	 */

	public int solution(int[] tab, int n, int f) {
		int result = -1;
		try {
			int[] tab2 = new int[tab.length - (2 * n)];
			int[] tab3 = new int[tab2.length - f + 1];

			// on remplie tab2

			for (int i = 0; i < tab2.length; i++) {
				tab2[i] = CalculerValeurTab2(tab, i + n, n);
			}

			// on remplie tab3

			for (int i = 0; i < tab3.length; i++) {
				tab3[i] = CalculerValeurTab3(tab2, i, f);
			}

			// on recupere l'indice de la plus haute valeur dans tab3

			int indicetab3 = IndicePlusGrand(tab3);
			// on recupere l'indice correspondant dans tab
			result = indicetab3 + n;
		} catch (Exception e) {

		}

		return result;
	}

	public int CalculerValeurTab2(int[] tab, int j, int n) {
		int result = 0;
		for (int i = j - n; i <= j + n; i++) {
			result += tab[i];
		}
		return result;
	}

	public int CalculerValeurTab3(int[] tab, int j, int f) {
		int result = 0;
		for (int i = j; i <= j + f - 1; i++) {
			result += tab[i];
		}
		return result;
	}

	public int IndicePlusGrand(int[] tab) {
		int result = 0;
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] > tab[result]) {
				result = i;
			}
		}
		return result;
	}
}
