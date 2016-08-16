package com.formation.etga.ctr;

public class main {

	public static void main(String[] args) {
		ExoAlgo5 a5 = new ExoAlgo5();
		String [] tab= {"123456001","123456002","123456001","456789001","123456003","123456001","123456003","123456003","456789002","654987001","654987003","123456005","456789002","456789002","456789510","456789510","789456245","123456001"};
		 String cat = "456789";
		int n = 2;
		a5.solution(tab, cat, n);

	}

}
