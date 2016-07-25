package com.formation.issa.main;

import com.formation.issa.exo.ExoAlgo1;

public class MainExoAlgo {

	public static void main(String[] args) {
		MainExoAlgo exo1Algo1=new MainExoAlgo();
		exo1Algo1.init();
		
	}

	private void init() {
		ExoAlgo1 algo1=new ExoAlgo1();
		int[]tab1={-1,3,-4,5,1,-6,2,1};
		int p=2;
		System.out.println(algo1.solution(tab1, p));
		
	}

}
