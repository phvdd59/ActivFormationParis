package com.formation.emma.exo;

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
		int diviseur = 0;

		if (n < 0) {
			diviseur = -1;
		} else {
			long u = (long) n+1;
			for (long m = 1; m < u; m++) {
				if (n % m != 0) {

				} else {
					diviseur++;
				}
			}
			if (diviseur == 0) {
				diviseur = -1;
			}
		}
		return diviseur;
	}
}
