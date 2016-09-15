package com.formation.jeci.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.jeci.ctr.ExoAlgo7;
import com.formation.jeci.exo.Dico;
import com.formation.jeci.exo.ExoAlgo4;
import com.formation.jeci.exo.ExoFlux1;
import com.formation.jeci.exo.ExoTableau1;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class Main {

	public static void main(String[] args) throws CruciException {
		Main tab = new Main();
		// tab.init();
//		tab.init2();
	//	tab.init3();
//		tab.init4();
		tab.init5();

	}

	private void init5() {
	ExoAlgo7 test=new ExoAlgo7();
		int [] tab={8,5};
		int a=test.solution(tab);
		System.out.println(a);
	}

	private void init4() {
		String l="12585";
		boolean t;
		t=l.matches("[0-9]{6}");
		System.out.println(t);
		
//		ExoFlux1 test= new ExoFlux1();
//		test.saisie();
//		test.save();
//		test.recup();
		
	}

	private void init3() throws CruciException {
		ExoAlgo4 test = new ExoAlgo4();
		Terme mot1 = new Terme("AB", new Point(0, 0), true);
		Terme mot2 = new Terme("CD", new Point(1, 0), true);
		Terme mot3 = new Terme("AC", new Point(0, 0), false);
		Terme mot4 = new Terme("BD", new Point(0, 1), false);
		ArrayList<Terme> lst = new ArrayList<>();
		lst.add(mot1);
		lst.add(mot2);
		lst.add(mot3);
		lst.add(mot4);

		test.solution(2, 2, lst);

	}

	private void init2() {

		Dico test = new Dico();
		String test1 = "SAlut a les thunes yya yya olive lès t'as reçu les  les les thùnés?";

		test.ranger(test1);
		ArrayList<String> tralala = test.getListeMot("l", 5);
		System.out.println(tralala);

		// TreeMap<Integer,ArrayList<Integer>> map=new
		// TreeMap<Integer,ArrayList<Integer>>();
		// for (int j = 1; j <= 5; j++) {
		// int key=j;
		// ArrayList<Integer> dico = new ArrayList<Integer>();
		//
		// for (int k = 0; k < 10; k++) {
		//
		// dico.add(k);
		//
		// }map.put(key, dico);
		//
		// }System.out.print(map);
		//
		//
		//
	}

	private void init() {
		// ExoSimple exo1 = new ExoSimple();
		// int tableau1[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		// System.out.println(exo1.sumTableau(tableau1));
		ExoTableau1 exo2 = new ExoTableau1();
		exo2.remplirTableau(2, 5, 6);
		// int []tab={0,1,2,3,4,5,6,7,8,9};
		// int[]tab1={6,6,6,6};
		// exo2.intervertirDeuxElementsTableau(tab, 3, 4);
		// exo2.insererUnElementDansTableau(tab, 5, 10);
		// exo2.insererUnTableauDansUnAutreAvecRemplacement(tab, 3, tab1);
		// exo2.rotationTableau(tab, 2);
	}
}
