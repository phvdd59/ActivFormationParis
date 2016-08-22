package com.formation.emma.main;

import java.util.Collections;

import com.formation.emma.ctr.ExoAlgo5;
import com.formation.emma.ctr.ExoAlgo6;
import com.formation.emma.ctr.ListeMeuble;
import com.formation.emma.ctr.Meuble;
import com.formation.emma.ctr.TRI;

public class Main2 {

	public static void main(String[] args) {
		Main2 main = new Main2();
		//	main.init();
		//main.init2();
		main.init3();
	}

	private void init3() {
		ListeMeuble lst = new ListeMeuble(TRI.ALPHA);
		Meuble meubleA = new Meuble(TRI.ALPHA, "AXA", "123", 2f, 2f, 2f);
		Meuble meubleB = new Meuble(TRI.ALPHA, "BXB", "323", 2f, 1f, 2f);
		Meuble meubleC = new Meuble(TRI.ALPHA, "AXB", "023", 2f, 3f, 2f);
		lst.add(meubleB);
		lst.add(meubleA);
		lst.add(meubleC);

		Collections.sort(lst);
		for (Meuble s : lst) {
			System.out.println(s + ",");
		}
	}

	private void init2() {
		ExoAlgo6 exo = new ExoAlgo6();
		int[] tab = { 1, 4, 7, 8, 4, 3, 7, 2, 8, 9, 2, 6, 3, 4, 1, 7, 9, 1, 1, 2 };
		int t = exo.solution(tab, 2, 3);
		System.out.println(t);
	}

	private void init() {
		ExoAlgo5 exo = new ExoAlgo5();
		String[] tab = { "123456789", "125741123", "123456102", "123456103", "145156231", "123456102", "123789456", "123456789", "123456789" };
		exo.solution(tab, "123456", 2);

	}

}
