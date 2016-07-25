package com.formation.beba.main;

import java.util.ArrayList;

import com.formation.beba.exo.ExoArrayList1;

public class MainArray {

	public static void main(String[] args) {
		MainArray mainArray = new MainArray();
		mainArray.init();
	}

	private void init() {

		ExoArrayList1 exoArray = new ExoArrayList1();
		ArrayList<Integer> test;
		test = exoArray.remplirTableau(10, 10, 10);
		System.out.println(test);

		ArrayList<Integer> test2 = exoArray.insererUnElementDansTableau(test, 4, 2);
		System.out.println(test2);

		ArrayList<Integer> test3 = exoArray.intervertirDeuxElementsTableau(test, -3, 5);
		System.out.println("intervertir" + test3);

		ArrayList<Integer> testX;
		testX = exoArray.remplirTableau(3, 3, 3);
		ArrayList<Integer> test4 = exoArray.insererUnTableauDansUnAutreAvecRemplacement(test, -3000, testX);
		System.out.println("ins" + test4);

		ArrayList<Integer> test5 = exoArray.rotationTableau(test, -5);
		System.out.println(test5);
	}

}
