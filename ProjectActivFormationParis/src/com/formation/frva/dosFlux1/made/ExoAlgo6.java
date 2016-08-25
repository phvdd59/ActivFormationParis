package com.formation.phva.dosFlux1.made;

import com.formation.phva.exo.InterAlgo6;

public class ExoAlgo6 implements InterAlgo6 {
	/**
	 * Chronologiquement le nombre de vente est stock� dans un tableau. IKAE souhaite conna�re la p�riode la plus faste des ventes. Nous avons un tableau tab constitu� d'entiers positifs. Afin de ne pas �tre affect� par des valeurs ponctuelles anormales il sera n�cessaire de lisser chaque �lement du tableau par ses "n" voisins � gauche et � droite les plus proches, avant de calculer sur une fen�tre de "f" valeurs correspondantes � une p�riode celle la plus favorable (ie celle dont la somme la
	 * plus importante). Attention on ne s'int�ressera pas aux n premiers �l�ments et aux n derniers �l�ments.
	 * 
	 * example : n=2 f=3 24 27 20 ---------------- ---------------- ---------------- | . | | . | | . | tab = [1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2 ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2 ] . . . . . . 29 28 27 22 19 20 | | | | ---------- ---------- . . 84 61
	 * 
	 * --> r�sultat indice : 7 --> valeurs maxi = 84 ([3+7+2+8+9]+[7+2+8+9+2]+[2+8+9+2+6])
	 * 
	 * Donnez le premier indice du tableau "tab" en partant de la gauche correspondant � la fen�tre "f" la plus favorable avec un lissage de n de part et d'autre. En cas d'impossibilit� renvoyer -1
	 */

	public int solution(int[] tab, int n, int f) {
		int indice = -1;
		if (tab == null || n <= 0 || f <= 0 || f > tab.length || n > (tab.length / 2)) {
			int[] tabMoyenne = new int[tab.length - (2 * n)];

			for (int i = 0; i < tabMoyenne.length; i++) {
				int moyenneElt = 0;
				for (int j = 0; j < tabMoyenne.length + 1; j++) {
					if (moyenneElt + tab[j + i] < Integer.MAX_VALUE || moyenneElt + tab[j + i] > Integer.MIN_VALUE) {
						moyenneElt = moyenneElt + tab[j + i];
					} else {
						break;
					}
				}
				tabMoyenne[i] = moyenneElt;
			}
			int[] tabSommeFenetre = new int[tabMoyenne.length - f + 1];
			for (int i = 0; i < tabSommeFenetre.length; i++) {
				int sommeFenetre = 0;
				for (int j = 0; j < tabMoyenne.length; j++) {
					if (sommeFenetre + tabMoyenne[j + i] < Integer.MAX_VALUE || sommeFenetre + tabMoyenne[j + i] > Integer.MIN_VALUE) {
						sommeFenetre += tabMoyenne[j + i];
					} else {
						break;
					}
				}
				tabSommeFenetre[i] = sommeFenetre;
			}
			int max = 0;
			for (int i = 0; i < tabSommeFenetre.length; i++) {
				if (tabSommeFenetre[i] > max) {
					max = tabSommeFenetre[i];
					indice = i + n;
				}
			}
		}
		return indice;
	}
}
