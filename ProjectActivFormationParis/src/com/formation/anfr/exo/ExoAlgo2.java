package com.formation.anfr.exo;

import java.util.ArrayList;

import org.w3c.dom.stylesheets.LinkStyle;

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
		int soluce = -1;
		if (n == 1) {
			soluce = 1;
		} else if (n > 0) {
			soluce = fonction(n);
		}
		return soluce;
	}

	public int fonction(int n) {
		boolean pair = false;
		int sol = 2;
		if (n % 2 == 0) {
			pair = true;
			sol +=2;
		}
		int i = 3;
		int refrence = (int) Math.sqrt(n);
		while (i <= refrence) {
			if (i == Math.sqrt(n)) {
				sol++;
			} else if (n % i == 0) {
				sol += 2;
//				refrence = n / i;
			}
			if (pair) {
				i++;
			} else {
				i +=2;
			}
		}
		return sol;
	}
}
