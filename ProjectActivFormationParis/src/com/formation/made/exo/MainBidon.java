package com.formation.made.exo;

public class MainBidon {

	public static void main(String[] args) {
		MainBidon test = new MainBidon();
		test.init();
	}

	private void init() {
		ExoSimple sommetableau = new ExoSimple();
		int[] nouvotablo = { 1, 2, 3, 18, 35, 42 };
		System.out.println(sommetableau.sumTableau(nouvotablo));
		

	}

}
