package com.formation.ambr.metier;

public class MainExoAlgo6 {

	public static void main(String[] args) {
		MainExoAlgo6 m = new MainExoAlgo6();
		m.init();
	}

	private void init() {
		ExoAlgo6New2 exo = new ExoAlgo6New2();
		int n = 2;
		int f = 3;
		int[] tab = {1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2 ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2};
		System.out.println(exo.solution(tab, n, f));
	}

}
