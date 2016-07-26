package com.formation.thcr.exo;

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

	public int solution(int n) {
		int cpt = 0;
		int a;
		if (n < 0) {
			a = Math.abs(n);
			for (int i = 1; i < a / 2; i++) {
				if (a % i == 0)
					cpt++;
			}
		} else {
			for (int i = 1; i < n / 2; i++) {
				if (n % i == 0)
					cpt++;
			}
		}
		return cpt;
	}

	public ArrayList<Integer> solution2(int n) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		int a;
		if (n < 0) {
			a = Math.abs(n);
			for (int i = 1; i < a / 2; i++) {
				if (a % i == 0)
					s.add(-i);
			}
		} else {
			for (int i = 1; i < n / 2; i++) {
				if (n % i == 0)
					s.add(i);
			}
		}
		return s;
	}
}
