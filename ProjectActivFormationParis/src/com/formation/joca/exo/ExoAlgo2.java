package com.formation.joca.exo;

import java.util.ArrayList;

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

	@Override
	public int solution(int n) {
		int result = 0;
		if (n != 0 && n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
			ArrayList<Integer> listeDiv = new ArrayList<Integer>();
			listeDiv.add((Integer) Math.abs(n));
			listeDiv.add((Integer) 1);
			for (int i = 2; i < (Math.abs(n) / 2) + 1; i++) {
				if (n % i == 0) {
					listeDiv.add((Integer) i);
				}
			}
			result = listeDiv.size();
		}
		return result;
	}
}
