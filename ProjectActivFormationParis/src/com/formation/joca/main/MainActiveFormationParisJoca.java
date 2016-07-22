package com.formation.joca.main;

import java.util.ArrayList;

import com.formation.joca.exo.ExoArrayList1;
import com.formation.joca.exo.ExoSimple;
import com.formation.joca.exo.ExoTableau1;
import com.formation.joca.exo.ExoTableau2;

public class MainActiveFormationParisJoca {

	public static void main(String[] arg) {
		MainActiveFormationParisJoca test = new MainActiveFormationParisJoca();
		test.init4();
	}

	public void afficherTableau(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println(" ");
	}

	public void afficherListe(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(" ");
	}

	private void init() {
		int[] tabTest = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exo1 = new ExoSimple();
		System.out.println(exo1.sumTableau(tabTest));

	}

	private void init2() {
		ExoTableau1 exo2 = new ExoTableau1();
		int[] tabTest = exo2.remplirTableau(7, 5, 3);
		this.afficherTableau(tabTest);

		tabTest = exo2.intervertirDeuxElementsTableau(tabTest, 2, 5);
		this.afficherTableau(tabTest);

		tabTest = exo2.insererUnElementDansTableau(tabTest, 3, 5);
		this.afficherTableau(tabTest);

		int[] tab2 = { 2, 8 };
		tabTest = exo2.insererUnTableauDansUnAutreAvecRemplacement(tabTest, 2, tab2);
		this.afficherTableau(tabTest);

		tabTest = exo2.rotationTableau(tabTest, 2);
		this.afficherTableau(tabTest);
	}

	private void init3() {
		int[] tabTest = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoTableau2 exo3 = new ExoTableau2();
		exo3.inverserTableau(tabTest);
		this.afficherTableau(tabTest);

	}

	private void init4() {
		int[] tab1 = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int i = 0; i < tab1.length; i++) {
			list1.add(tab1[i]);
		}
		this.afficherListe(list1);

		int[] tab2 = { 2, 2, 9, 3 };
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < tab2.length; i++) {
			list2.add(tab2[i]);
		}
		// this.afficherListe(list2);

		ExoArrayList1 exo4 = new ExoArrayList1();

		ArrayList<Integer> list3 = exo4.remplirTableau(8, 16, -8);
		this.afficherListe(list3);

		list3.clear();
		list3 = exo4.intervertirDeuxElementsTableau(list1, 2, 5);
		this.afficherListe(list3);

		list3.clear();
		list3 = exo4.insererUnElementDansTableau(list1, 7, 5);
		this.afficherListe(list3);

		list3.clear();
		list3 = exo4.insererUnTableauDansUnAutreAvecRemplacement(list1, -7, list2);
		this.afficherListe(list3);

		list3.clear();
		list3 = exo4.rotationTableau(list1, 458);
		this.afficherListe(list3);
	}
}
