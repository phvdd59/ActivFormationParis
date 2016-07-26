package com.formation.beba.main;

import com.formation.beba.exo.ExoAlgo2;
import com.formation.beba.exo.ExoAlgo2bis;

public class MainAlgo2 {

	public static void main(String[] args) {
		MainAlgo2 mainAlgo2 = new MainAlgo2();
		mainAlgo2.init();
	}

	private void init() {
		ExoAlgo2 exoAlgo2 = new ExoAlgo2();

		int test = exoAlgo2.solution(4);
		System.out.println(test);

		ExoAlgo2bis exoAlgo2bis = new ExoAlgo2bis();

		int test2 = exoAlgo2bis.solution(24);
		System.out.println(test2);

	}

}
