package com.formation.etga.exo;

public class Main {

	public static void main(String[] args) {
//		ExoAlgo5 a5 = new ExoAlgo5();
//		String [] tab= {"123456001","123456002","123456001","456789001","123456003","123456001","123456003","123456003","456789002","654987001","654987003","123456005","456789002","456789002","456789510","456789510","789456245","123456001"};
//		 String cat = "456789";
//		int n = 2;
//		a5.solution(tab, cat, n);

		ExoAlgo6 a6  = new ExoAlgo6();
		int [] tab = {1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2 ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2};
		int indice = a6.solution(tab, 2, 3);
		System.out.println(indice);
	}

}
