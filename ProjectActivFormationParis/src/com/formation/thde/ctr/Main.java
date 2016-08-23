package com.formation.thde.ctr;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		//main.init();
//		main.init2();
		main.init3();
	}

//	private void init() {
//		ExoAlgo5 exo5 = new ExoAlgo5();
//		String[] tab = { "123456001", "123456002", "123456001", "456789001", "123456003", "123456001", "123456003", "123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510", "456789510", "789456245", "123456001" };
//		int n = 5;
//		String cat = "123456";
//		String[] newTab = exo5.solution(tab, cat, n);
//		for (int i = 0; i < newTab.length; i++) {
//			System.out.println(newTab[i]);
//		}
//	}

	private void init2() {
		ExoAlgo6 exo6 = new ExoAlgo6();
		int[] tab = { 1, 4, 7, 8, 4, 3, 7, 2, 8, 9, 2, 6, 3, 4, 1, 7, 9, 1, 1, 2 };
		int n = 2;
		int f = 3;
		int sol = exo6.solution(tab, n, f);
		System.out.println(sol);
	}
	
	private void init3() {
		ListeMeuble lst = new ListeMeuble(Tri.ALPHA);
		lst.add(new Meuble(Tri.ALPHA, "glumph", "002", 1, 2, 3));
		lst.add(new Meuble(Tri.REF, "aglumph", "012", 1, 2, 3));
		lst.add(new Meuble(Tri.REF, "bglumph", "014", 1, 2, 3));
		Collections.sort(lst);
		System.out.println(lst);
		
	}
}
