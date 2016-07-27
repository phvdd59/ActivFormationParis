package com.formation.ambr.main;

import java.util.ArrayList;

import com.formation.ambr.exo.ExoAlgo1;
import com.formation.ambr.exo.ExoAlgo2;
import com.formation.ambr.exo.ExoArrayList1;
import com.formation.ambr.exo.ExoSimple;
import com.formation.ambr.exo.ExoTableau1;
import com.formation.ambr.exo.ExoTableau2;

public class Main {

	public static void main(String[] args) { // main method

		Main main = new Main();
		main.init6();

	}

	private void init() {
		int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		//int a = 5;
		ExoSimple exoSimple = new ExoSimple(); // on construit un ExoSimple qui s'appelle exoSimple

		int autreSomme = exoSimple.sumTableau(tab);// on dit que autreSomme c'est sumTableau de tab, dans la méthode exoSimple, qui est une méthode (un patron) de type ExoSimple. Et sumTableau nous retourne une somme
		System.out.println(autreSomme); // on lui demande de nous afficher autreSomme

		/////////

		//ExoTableau1
		System.out.println("-----ExoTableau1-----");

		//1. remplirTableau

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(2, 31));
		System.out.println(Integer.MIN_VALUE);

		System.out.println("*I.remplirTableau*");
		ExoTableau1 exoTableau1 = new ExoTableau1();
		int[] tableauRempli = exoTableau1.remplirTableau(0x7FFFFFF0, 16, 8);
		//faut protéger ça aussi
		if (tableauRempli == null) {
			System.out.println("Y'a un problème");
		} else {
			for (int i = 0; i < tableauRempli.length; i++) {
				System.out.print(tableauRempli[i] + " ");
			}
		}
		System.out.println("\r");

		//2. intervertirDeuxElementsTableau
		System.out.println("*II.intervertirDeuxElementsTableau*");
		ExoTableau1 exoTableau2 = new ExoTableau1();
		//int[] tabOrig = exoTableau2.remplirTableau(7, 9, 3);
		int[] tabOrig = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig.length; i++) {
			System.out.print(tabOrig[i] + " ");
		}
		System.out.println("\r");
		int[] tabInterv = exoTableau2.intervertirDeuxElementsTableau(tabOrig, 3, 8);
		System.out.println("Tableau Interverti");
		if (tabInterv == null) {
			System.out.println("Y'a un problème");
		} else {
			for (int i = 0; i < tabInterv.length; i++) {
				System.out.print(tabInterv[i] + " ");
			}
			System.out.println("\r");
		}

		//3. insererUnElementDansTableau
		System.out.println("*III.insererUnElementDansTableau*");
		ExoTableau1 exoTableau3 = new ExoTableau1();
		int[] tabOrig2 = { 1, 4, 6, 2, 4, 6 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig2.length; i++) {
			System.out.print(tabOrig2[i] + " ");
		}
		System.out.println("\r");
		int[] tabRes2 = exoTableau3.insererUnElementDansTableau(tabOrig2, 33333, 8);
		System.out.println("Tableau Résultat");
		if (tabRes2 == null) {
			System.out.println("Y'a un problème");
		} else {
			for (int i = 0; i < tabRes2.length; i++) {
				System.out.print(tabRes2[i] + " ");
			}
		}
		System.out.println("\r");

		//4. insererUnTableauDansUnAutreAvecRemplacement
		System.out.println("*IV.insererUnTableauDansUnAutreAvecRemplacement*");
		ExoTableau1 exoTableau4 = new ExoTableau1();
		int[] tabOrig3 = { 1, 4, 6, 2, 4, 7 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig3.length; i++) {
			System.out.print(tabOrig3[i] + " ");
		}
		System.out.println("\r");
		int[] tabDeRemp = { 4, 9, 0 };
		System.out.println("Tableau de remplacement");
		for (int i = 0; i < tabDeRemp.length; i++) {
			System.out.print(tabDeRemp[i] + " ");
		}
		System.out.println("\r");
		int[] tabRes3 = exoTableau4.insererUnTableauDansUnAutreAvecRemplacement(tabOrig3, -3, tabDeRemp);
		System.out.println("Tableau Résultat");
		// nouvelle version
		for (int i = 0; i < tabRes3.length; i++) {
			System.out.print(tabRes3[i] + " ");
		}
		System.out.println("\r");
		// ancienne version
		//		if (tabRes3 == tabOrig3.clone()) {
		//			System.out.println("Y'a un problème");
		//		} else {
		//			for (int i = 0; i < tabRes3.length; i++) {
		//				System.out.print(tabRes3[i] + " ");
		//			}
		//			System.out.println("\r");
		//		}

		//5. rotationTableau
		System.out.println("*V.rotationTableau*");
		ExoTableau1 exoTableau5 = new ExoTableau1();
		int[] tabOrig4 = { 1, 4, 6, 2, 4, 6 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig4.length; i++) {
			System.out.print(tabOrig4[i] + " ");
		}
		System.out.println("\r");
		System.out.println("Tableau après rotation");
		int[] tabRota = exoTableau5.rotationTableau(tabOrig4, 3000);
		if (tabRota == null) {
			System.out.println("Y'a un problème");
		} else {
			for (int i = 0; i < tabRota.length; i++) {
				System.out.print(tabRota[i] + " ");
			}
		}
		System.out.println("\r");

	}

	private void init2() {

		System.out.println("-----ExoArrayList1-----");

		//1. remplirTableau
		System.out.println("*I.remplirTableau*");
		ExoArrayList1 exoArrayList1 = new ExoArrayList1();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		//list1.add(7);
		//list1.add(48);
		list1 = exoArrayList1.remplirTableau(7, 5, 3);
		System.out.println(list1);

		// 2.méthode intervertirDeuxElementsTableau
		System.out.println("*II.intervertirDeuxElementsTableau*");
		ExoArrayList1 exoArrayList2 = new ExoArrayList1();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(7);
		list2.add(10);
		list2.add(13);
		list2.add(16);
		list2.add(19);
		list2.add(21);
		list2.add(24);
		list2.add(27);
		list2.add(30);
		//list2=exoArrayList2.intervertirDeuxElementsTableau(tab, i1, i2);

	}

	private void init3() {

		System.out.println("-----ExoAlgo1-----");

	}

	private void init4() {

		System.out.println("-----ExoTableau2-----");

		//1. inverserTableau
		System.out.println("*I.inverserTableau*");
		ExoTableau2 exoTableau1 = new ExoTableau2();
		int[] tab = { 1, 4, 6, -5, 7, 5 };
		int[] tabInv = exoTableau1.inverserTableau(tab);
		for (int i = 0; i < tabInv.length; i++) {
			System.out.print(tabInv[i] + " ");
		}
		System.out.println("\r");

		//2. rallongerTableauDeUnElement
		System.out.println("*II.rallongerTableauDeUnElement*");
		ExoTableau2 exoTableau2 = new ExoTableau2();
		int[] tab2 = { 1, 4, 6, 2, 4, 6 };
		int[] tabRllng = exoTableau2.rallongerTableauDeUnElement(tab2, 8);
		for (int i = 0; i < tabRllng.length; i++) {
			System.out.print(tabRllng[i] + " ");
		}
		System.out.println("\r");

		//3. insererUnTableauDansUnAutre
		System.out.println("*III.insererUnTableauDansUnAutre*");
		ExoTableau2 exoTableau3 = new ExoTableau2();
		int[] tab3 = { 1, 4, 6, 2, 4, 6 };
		int[] tabDeRemp = { 4, 9, 0 };
		int[] tabInser = exoTableau3.insererUnTableauDansUnAutre(tab3, 2, tabDeRemp);
		for (int i = 0; i < tabInser.length; i++) {
			System.out.print(tabInser[i] + " ");
		}
		System.out.println("\r");

		//4. changerDimensionTableau
		System.out.println("*IV.changerDimensionTableau*");
		ExoTableau2 exotableau4 = new ExoTableau2();
		int[] tab4 = { 1, 7, 8, 2, 4, 6 };
		int[][] tabDim = exotableau4.changerDimensionTableau(tab4, 2);
		for (int i = 0; i < tabDim.length; i++) {
			System.out.println(tabDim[i]);
		}

		//5. tabBaseDeux
		System.out.println("*V.tabBaseDeux*");
		ExoTableau2 exoTableau5 = new ExoTableau2();
		int[] tab5 = exoTableau5.tabBaseDeux(18);

	}

	private void init5() {
		System.out.println("-----ExoAlgo1-----");
		ExoAlgo1 exoAlgo1 = new ExoAlgo1();
		int[] tab = { -1, 3, -4, 5, 1, -6, 2, 1 };
		int pos = exoAlgo1.solution(tab);
		System.out.println(pos);
	}

	private void init6() {
		System.out.println("-----ExoAlgo2-----");
		ExoAlgo2 exoAlgo2 = new ExoAlgo2();
		int solution = exoAlgo2.solution(8);
		System.out.println(solution);
	}

}
