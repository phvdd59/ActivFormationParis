package com.formation.made.main;

import com.formation.made.exo.ExoAlgo1;
import com.formation.made.exo.ExoAlgo2;

public class MainAlgo {

	public static void main(String[] args) {
		MainAlgo mainAlgo = new MainAlgo();
		mainAlgo.init();
	} 

	private void init() {
		ExoAlgo1 exoalgo = new ExoAlgo1();
		int[] tableau = { 1, 3, 5, 7, 9, 2, 4, 6, 8 };
		int[] tableaunull = { 10000000 };
		int[] tableau1 = { 3,-2,-1,4,-6,8,-5,2,1};
		//System.out.println(exoalgo.solution(tableau1));
		ExoAlgo2 exoalgo2 = new ExoAlgo2();
		System.out.println(exoalgo2.solution2(49));
	}

}
