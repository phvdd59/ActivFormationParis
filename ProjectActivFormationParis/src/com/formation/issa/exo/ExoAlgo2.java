package com.formation.issa.exo;

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
		if (n <= 0) {
			return 0;
		}

		int d = 0;
		int m = 0;
		int cpt = 0;

		for (d = 1; d <= n; d++) {

			for (m = 1; m <= n; m++) {
				if (n == d * m) {
					//System.out.print(d + ",");
					cpt++;

				}

			}

		}
		//System.out.println("Le nombre de diviseurs est égal à "+cpt);

		return cpt;
	}

}
