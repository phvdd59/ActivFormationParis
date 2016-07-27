package com.formation.ambr.exo;

import com.formation.phva.exo.ImpAlgo2;

public class ExoAlgo2 implements ImpAlgo2 {

	/**
	 * Un entier positif d est un diviseur de n si il existe un entier m tel que
	 * n = d * m;
	 * 
	 * par exemple 6 est un diviseur de 24 car m = 4 24=6*4
	 * 
	 * ecrire : int fonction(int n) qui retour le nombre de diviseur de n.
	 * 
	 * par exemple 24 possede 8 diviseur : [1,2,3,4,6,8,12,24]
	 * 
	 */

	public int solution(int n) {
		//int d;
		//int m;
		int j = 0;
		//int[] tab = new int[n];
		//n=d*m;
		if (n <= 0) {
			return -1;
		}
		for (long i = 1; i <= n; i++) { // long car sinon va passer de 2147483647 à -2147483648 (limites d'un int) et ensuite va passer par 0, donc diviser par 0
			if (n % i == 0) {
				//tab[j] = i; // au final ce tableau sert à rien, on pourrait juste faire un compteur. J'ai essayé de faire grandir le tableau au fur et à mesure, en mettant dans ce if "int[] tab = new int[n]" mais ça lui met des 0 ailleurs qu'en j. Faudrait une ArrayList?
				j++;
			}
		}
		return j;
	}
}
