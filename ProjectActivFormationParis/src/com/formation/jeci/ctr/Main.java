package com.formation.jeci.ctr;

public class Main {
	public static void main(String[] args) {
		Main test = new Main();
		test.init();
	}

	private void init() {
		String[] tab = { "123456001", "123456002", "123456001", "456789001", "123456003", "123456001", "123456003", "123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510", "456789510", "789456245", "123456001" };
		String cat = "123456";
		int n =5;
		ExoAlgo5 t=new ExoAlgo5();
		String []lol=new String[n];
		lol=t.solution(tab, cat, n);
		for (String string : lol) {
			System.out.println(string);
		}
		
	}
}
