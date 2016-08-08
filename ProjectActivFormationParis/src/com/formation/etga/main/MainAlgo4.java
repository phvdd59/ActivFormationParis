package com.formation.etga.main;

import com.formation.etga.exo.ExoFlux1;

public class MainAlgo4 {

	public static void main(String[] args) {

		//		ArrayList<Terme> lst = new ArrayList<Terme>();
		//
		//		Terme t1 = new Terme(new String("AB"), new Point(0, 0), Terme.HORIZONTAL);
		//		lst.add(t1);
		//		Terme t2 = new Terme("AC", new Point(0, 0), Terme.VERTICAL);
		//		lst.add(t2);
		//		Terme t3 = new Terme("CD", new Point(0, 1), Terme.HORIZONTAL);
		//		lst.add(t3);
		//		Terme t4 = new Terme("BD", new Point(1, 1), Terme.VERTICAL);
		//		lst.add(t4);
		//
		//		//		ExoAlgo4Exce exoAlgo4 = new ExoAlgo4Exce();
		//		//		char[][] tabSolution = exoAlgo4.solution(4, 4, lst);
		//		//		System.out.println(tabSolution);
		//
		//		ExoException1 exoException1 = new ExoException1();
		//		char[][] cruci = exoException1.solution(4, 0, lst);
		//		System.out.println(cruci);
		//		
		ExoFlux1 exoFlux1 = new ExoFlux1();
		exoFlux1.saisie();
		exoFlux1.recup();
		exoFlux1.save();

	}
}
