package com.formation.made.exo;

import com.formation.phva.exo.ImpAlgo2;

public class ExoAlgo2 implements ImpAlgo2 {

	/**
	 * Un entier positif d est un diviseur de n si il existe un entier m tel que n = d * m;
	 * 
	 * par exemple 6 est un diviseur de 24 car m = 4 24=6*4
	 * 
	 * ecrire : int fonction(int n) qui retour le nombre de diviseur de n.
	 * 
	 * par exemple 24 possede 8 diviseur : [1,2,3,4,6,8,12,24]
	 * 
	 */

	public int solution(int n) {
		int compteur = -1;
		// ArrayList<Integer> listavaleurs = new ArrayList<>();
		if (n == 0) {
		} else if (n > 0) {
			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					compteur++;
					// listavaleurs.add(i);
				}
			}
			// listavaleurs.add(n);
			compteur += 2;
		}
		// System.out.println(listavaleurs.toString());
		return compteur;
	}
}
