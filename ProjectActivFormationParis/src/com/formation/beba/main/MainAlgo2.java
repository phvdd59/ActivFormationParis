package com.formation.beba.main;

import com.formation.beba.exo.ExoAlgo2;

public class MainAlgo2 {

	public static void main(String[] args) {
		MainAlgo2 mainAlgo2 = new MainAlgo2();
		mainAlgo2.init();
	}

	private void init() {
		ExoAlgo2 exoAlgo2 = new ExoAlgo2();

		int test = exoAlgo2.solution(13);
		System.out.println(test);

	}

}
