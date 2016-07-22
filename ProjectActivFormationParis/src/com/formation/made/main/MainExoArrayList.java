package com.formation.made.main;

import java.util.ArrayList;

import com.formation.made.exo.ExoArrayList1;

public class MainExoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainExoArrayList mainExoArrayList = new MainExoArrayList();
		mainExoArrayList.init();
	}

	private void init() {
		ExoArrayList1 listexoA = new ExoArrayList1();
		ArrayList<Integer> listExo = new ArrayList<>();
		listexoA.remplirTableau(3, 5, 2);
		for (int i = 0; i < 10; i++) {
			listExo.add((i));
		}
		// System.out.println(listExo.toString());
		// System.out.println(listexoA.intervertirDeuxElementsTableau(listExo, 2, 5));
		// System.out.println(listexoA.insererUnElementDansTableau(listExo, 3, 33));
		ArrayList<Integer> listExo2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listExo2.add((40 - 10 * i));
		}
		// System.out.println(listexoA.insererUnTableauDansUnAutreAvecRemplacement(listExo, 0, listExo2));
		// System.out.println(listExo2);
		System.out.println(listexoA.rotationTableau(listExo2, 0));
	}

}
