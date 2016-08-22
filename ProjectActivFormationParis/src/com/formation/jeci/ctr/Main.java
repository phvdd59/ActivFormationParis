package com.formation.jeci.ctr;

public class Main {
	public static void main(String[] args) {
		Main test = new Main();
		test.init();
	}

	private void init() {
//		String[] tab = { "123456001", "123456002", "123456001", "456789001", "123456003", "123456001", "123456003", "123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510", "456789510", "789456245", "123456001" };
//		String cat = "123456";
//		int n =5;
//		ExoAlgo5 t=new ExoAlgo5();
//		String []lol=new String[n];
//		lol=t.solution(tab, cat, n);
//		for (String string : lol) {
//			System.out.println(string);
//		}
		int Tab[]={1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2 };
		ExoAlgo6 t1=new ExoAlgo6();
		int n=2;
		int f=3;
		
		int l=t1.solution(Tab, n, f);
		System.out.println(l);
	}
}
