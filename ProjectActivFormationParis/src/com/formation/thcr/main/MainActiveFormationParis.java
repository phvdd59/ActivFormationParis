package com.formation.thcr.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.formation.thcr.exo.ExoAlgo1;
import com.formation.thcr.exo.ExoAlgo2;
import com.formation.thcr.exo.ExoArrayList1;
import com.formation.thcr.exo.ExoTableau1;
import com.formation.thcr.exo.ExoTableau2;

public class MainActiveFormationParis {

	public static void main(String[] args) {
		MainActiveFormationParis main = new MainActiveFormationParis();
		main.initAlgo2();
	}

	private void initAlgo2() {
		ExoAlgo2 exo = new ExoAlgo2();
		int n = 24;		
		long start = System.currentTimeMillis();
		int nbDiviseur = exo.solution(n);
		System.out.println("Nombre de diviseur de " + n + " : " + nbDiviseur);
		long end = System.currentTimeMillis() - start;
		System.out.println("time : " + end + "ms");
		System.out.println();
	}

	private void initAlgo() {
		ExoAlgo1 exo = new ExoAlgo1();
		int[] tab = { -1, 3, -4, 5, 1, -6, 2, 1 };
		System.out.println(exo.solution(tab));
		System.out.println(Arrays.toString(exo.solution2(tab).toArray()));
	}

	private void initExoArrayList1() {
		ExoArrayList1 exo = new ExoArrayList1();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		System.out.println("remplirTableau");
		list1 = exo.remplirTableau(-0x7FFFFFF0, 16, -8);
		System.out.println(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2 = exo.remplirTableau(0, 20, 3);
		System.out.println(list2);
		System.out.println();
		System.out.println("intervertirDeuxElementsTableau");
		System.out.println(list1);
		System.out.println(exo.intervertirDeuxElementsTableau(list1, 2, 3));
		System.out.println();
		System.out.println("insererUnElementDansTableau");
		System.out.println(list1);
		System.out.println(exo.insererUnElementDansTableau(list1, 2, 8));
		System.out.println();
		System.out.println("insererUnTableauDansUnAutreAvecRemplacement");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(exo.insererUnTableauDansUnAutreAvecRemplacement(list1, 5, list2));
		System.out.println();
		System.out.println("rotationTableau");
		System.out.println(exo.rotationTableau(list1, -21));

	}

	private void initExoTableau2() {
		ExoTableau2 exo = new ExoTableau2();
		System.out.println("inverserTableau");
		int[] tab = { 1, 4, 6, -5, 7, 5 };
		System.out.println(Arrays.toString(tab));
		System.out.println(Arrays.toString(exo.inverserTableau(tab)));
		System.out.println("rallongerTableauDeUnElement");
		int[] tab2 = { 1, 4, 6, 2, 4, 6 };
		System.out.println(Arrays.toString(tab2));
		System.out.println(Arrays.toString(exo.rallongerTableauDeUnElement(tab2, 8)));
		System.out.println("insererUnTableauDansUnAutre");
		int[] tab31 = { 1, 4, 6, 2, 4, 6 };
		int[] tab32 = { 4, 9, 1 };
		System.out.println(Arrays.toString(tab31));
		System.out.println(Arrays.toString(tab32));
		System.out.println(Arrays.toString(exo.insererUnTableauDansUnAutre(tab31, 5, tab32)));
		System.out.println("changerDimensionTableau");
		int[] tab4 = { 1, 7, 8, 2, 4, 6 };
		int d = 2;
		System.out.println(Arrays.toString(tab4));
		int[][] result = new int[d][tab4.length / d];
		result = exo.changerDimensionTableau(tab4, d);
		for (int i = 0; i < tab4.length / d; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
		d = 8;
		result = exo.changerDimensionTableau(tab4, d);
		if (tab4.length / d == 0) {
			for (int i = 0; i < tab4.length / d + 1; i++) {
				System.out.println(Arrays.toString(result[i]));
			}
		} else {
			for (int i = 0; i < tab4.length / d + 1; i++) {
				System.out.println(Arrays.toString(result[i]));
			}
		}
		System.out.println("tabBaseDeux");
		int v = Integer.MIN_VALUE;
		System.out.println(Integer.valueOf(v).toString());
		System.out.println(Arrays.toString(exo.tabBaseDeux(v)));
		v = Integer.MAX_VALUE;
		System.out.println(Integer.valueOf(v).toString());
		System.out.println(Arrays.toString(exo.tabBaseDeux(v)));
	}

	private void initExoTableau1() {
		ExoTableau1 exo = new ExoTableau1();
		System.out.println("remplirTableau");
		System.out.println(Arrays.toString(exo.remplirTableau(0x7F_FF_FF_FF, 10, 2)));
		int[] tab = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int i1 = 4, i2 = 50;
		System.out.println("intervertirDeuxElementsTableau");
		System.out.println(Arrays.toString(tab));
		System.out.println(Arrays.toString(exo.intervertirDeuxElementsTableau(tab, i1, i2)));
		int[] tab2 = { 1, 4, 6, 2, 4, 6 };
		int p = -3, a = 8;
		System.out.println("insererUnElementDansTableau");
		System.out.println(Arrays.toString(tab2));
		System.out.println(Arrays.toString(exo.insererUnElementDansTableau(tab2, p, a)));
		int[] tab3 = { 1, 4, 6, 2, 4, 7 };
		int[] tab4 = { 4, 9, 0 };
		p = 4;
		System.out.println("insererUnTableauDansUnAutreAvecRemplacement");
		System.out.println(Arrays.toString(tab3));
		System.out.println(Arrays.toString(tab4));
		System.out.println("-----");
		System.out.println(
				Arrays.toString(exo.insererUnTableauDansUnAutreAvecRemplacement(tab3, p, tab4)));
		System.out.println("-----");
		int[] tab5 = { 22, 11, 0, 77, 88, 99 };
		int[] tab6 = { 3, 4, 5, 6 };
		p = 2;
		System.out.println(Arrays.toString(tab5));
		System.out.println(Arrays.toString(tab6));
		System.out.println("-----");
		System.out.println(
				Arrays.toString(exo.insererUnTableauDansUnAutreAvecRemplacement(tab5, p, tab6)));
		System.out.println("-----");
		int[] tab7 = { 1, 4, 6, 2, 4, 6 };
		p = 2;
		System.out.println(Arrays.toString(tab7));
		System.out.println(Arrays.toString(exo.rotationTableau(tab7, p)));
		p = -1;
		System.out.println(Arrays.toString(tab7));
		System.out.println(Arrays.toString(exo.rotationTableau(tab7, p)));
	}
}
