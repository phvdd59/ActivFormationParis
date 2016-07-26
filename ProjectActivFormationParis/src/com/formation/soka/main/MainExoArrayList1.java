package com.formation.soka.main;

import java.util.ArrayList;

import com.formation.soka.exo.ExoArrayList1;

public class MainExoArrayList1 {

	public static void main(String[] args) {
		MainExoArrayList1 m = new MainExoArrayList1();
		m.init();

	}

	private void init() {
		ExoArrayList1 exoArrayList1 = new ExoArrayList1();
		exoArrayList1.remplirTableau(7, 5, 3);
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(4);
		array.add(6);
		array.add(2);
		array.add(4);
		array.add(6);
		ArrayList<Integer> array2 = new ArrayList<>();
		array2.add(3);
		array2.add(5);
		array2.add(7);

		//exoArrayList1.intervertirDeuxElementsTableau(array, 3, 5);
		//exoArrayList1.insererUnElementDansTableau(array, 3, 5);
		exoArrayList1.insererUnTableauDansUnAutreAvecRemplacement(array, 2, array2);
		//		exoArrayList1.rotationTableau(array, -2);
	}

}
