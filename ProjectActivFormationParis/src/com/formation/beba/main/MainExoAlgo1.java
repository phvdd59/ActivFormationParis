package com.formation.beba.main;

import com.formation.beba.exo.ExoAlgo1;

public class MainExoAlgo1 {

	public static void main(String[] args) {
		MainExoAlgo1 mainExoAlgo1 = new MainExoAlgo1();
		mainExoAlgo1.init();
	}

	private void init() {
		ExoAlgo1 exoAlgo1 = new ExoAlgo1();

		int[] tab = { 1,2,3,5,4,8,6,3,1,87 };
		int test = exoAlgo1.solution(tab);
		System.out.println(test);
		// ExoTableau1 exoTab = new ExoTableau1();
	}
}
