package com.formation.beba.exo;

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

	public int solution(int n) { // opti
		int nbDiviseur = -1;
		int racine = (int) Math.sqrt(n);
		if (n == 1) {
			nbDiviseur = 1;
		} else if (n > 0) {
			nbDiviseur = 0;
			if (n % 2 == 0) {
				for (int i = 1; i < racine + 1; i++) {
					if (n % i == 0) {
						if (n / i > i) {
							nbDiviseur += 2;
						} else if (n / i == i) {
							nbDiviseur += 1;
							break;
						}
					}
				}
			} else {
				for (int i = 1; i < racine + 1; i += 2) {
					if (n % i == 0) {
						if (n / i > i) {
							nbDiviseur += 2;
						} else if (n / i == i) {
							nbDiviseur += 1;
							break;
						}
					}
				}
			}
		}
		return nbDiviseur;
	}
}
