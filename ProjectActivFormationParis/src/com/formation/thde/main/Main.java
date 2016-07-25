package com.formation.thde.main;

import java.util.ArrayList;

import com.formation.thde.exo.ExoAlgo1;
import com.formation.thde.exo.ExoArrayList1;
import com.formation.thde.exo.ExoTableau1;
import com.formation.thde.exo.ExoTableau2;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		//main.init();
		//main.init2();
		//main.init3();
		main.init4();
	}

	private void init() {
		ExoTableau1 exo1 = new ExoTableau1();
		int[] tab1 = exo1.remplirTableau(7, 5, 3);
		if (tab1 != null) {
			for (int i = 0; i < tab1.length; i++) {
				System.out.print(tab1[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] test = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int[] tab2 = exo1.intervertirDeuxElementsTableau(test, 3, 8);
		if (tab2 != null) {
			for (int i = 0; i < tab2.length; i++) {
				System.out.print(tab2[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] test2 = { 1, 4, 6, 2, 4, 6 };
		int[] tab3 = exo1.insererUnElementDansTableau(test2, 3, 8);
		if (tab3 != null) {
			for (int i = 0; i < tab3.length; i++) {
				System.out.print(tab3[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] test3 = { 22, 11, 0, 77, 88, 99 };
		int[] test4 = { 3, 4, 5, 6 };
		int[] tab4 = exo1.insererUnTableauDansUnAutreAvecRemplacement(test3, 2, test4);
		if (tab4 != null) {
			for (int i = 0; i < tab4.length; i++) {
				System.out.print(tab4[i] + " ");
			}
		}
		System.out.print("\n");
		int[] test5 = { 1, 4, 6, 2, 4, 6 };
		int[] tab5 = exo1.rotationTableau(test5, 2);
		if (tab5 != null) {
			for (int i = 0; i < tab5.length; i++) {
				System.out.print(tab5[i] + ", ");
			}
		}
	}

	private void init2() {
		ExoArrayList1 exolist1 = new ExoArrayList1();
		ArrayList<Integer> list1 = exolist1.remplirTableau(7, 5, 3);
		if (list1 != null) {
			System.out.print("\n");
			System.out.print(list1 + ", ");
		}
		System.out.print("\n");
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(7);
		test.add(10);
		test.add(13);
		test.add(16);
		test.add(19);
		test.add(21);
		test.add(24);
		test.add(27);
		test.add(30);
		ArrayList<Integer> list2 = exolist1.intervertirDeuxElementsTableau(test, 3, 8);
		System.out.print(list2 + ", ");
		System.out.print("\n");

		ArrayList<Integer> test2 = new ArrayList<Integer>();
		test2.add(1);
		test2.add(4);
		test2.add(6);
		test2.add(2);
		test2.add(4);
		test2.add(6);
		ArrayList<Integer> list3 = exolist1.insererUnElementDansTableau(test2, 3, 8);
		System.out.print(list3 + ", ");

		System.out.print("\n");
		ArrayList<Integer> test3 = new ArrayList<Integer>();
		test3.add(22);
		test3.add(11);
		test3.add(0);
		test3.add(77);
		test3.add(88);
		test3.add(99);
		ArrayList<Integer> test4 = new ArrayList<Integer>();
		test4.add(3);
		test4.add(4);
		test4.add(5);
		test4.add(6);
		ArrayList<Integer> list4 = exolist1.insererUnTableauDansUnAutreAvecRemplacement(test3, 2, test4);
		System.out.print(list4 + " ");

		System.out.print("\n");
		ArrayList<Integer> test5 = new ArrayList<Integer>();
		test5.add(1);
		test5.add(4);
		test5.add(6);
		test5.add(2);
		test5.add(4);
		test5.add(6);
		ArrayList<Integer> list5 = exolist1.rotationTableau(test5, 2);
		System.out.print(list5 + ", ");
	}

	private void init3() {
		System.out.print("\n");
		ExoTableau2 exo2 = new ExoTableau2();
		int[] test6 = { 1, 4, 6, -5, 7, 5 };
		int[] tab6 = exo2.inverserTableau(test6);
		if (tab6 != null) {
			for (int i = 0; i < tab6.length; i++) {
				System.out.print(tab6[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] test7 = { 1, 4, 6, 2, 4, 6 };
		int[] tab7 = exo2.rallongerTableauDeUnElement(test7, 8);
		if (tab7 != null) {
			for (int i = 0; i < tab7.length; i++) {
				System.out.print(tab7[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] test8 = { 1, 4, 6, 2, 4, 6 };
		int[] test9 = { 4, 9, 0 };
		int[] tab8 = exo2.insererUnTableauDansUnAutre(test8, 2, test9);
		if (tab8 != null) {
			for (int i = 0; i < tab8.length; i++) {
				System.out.print(tab8[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] test10 = { 1, 7, 8, 2, 4, 6 };
		int testTaille = 2;
		int[][] tab9 = exo2.changerDimensionTableau(test10, testTaille);
		if (tab9 != null) {
			for (int i = 0; i < test10.length / testTaille; i++) {
				for (int j = 0; j < testTaille; j++) {
					System.out.print(tab9[i][j] + ", ");
				}
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		int tab10[] = exo2.tabBaseDeux(-18);
		if (tab10 != null) {
			for (int i = 0; i < tab10.length; i++) {
				System.out.print(tab10[i] + ", ");
			}
		}
	}

	private void init4() {
		ExoAlgo1 exo3 = new ExoAlgo1();
		int[] test11 = { 0, 0, 0, 0, 1 };
		int equilibre = exo3.solution(test11);
		System.out.print(equilibre);
	}
}
