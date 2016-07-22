package com.formation.thcr.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.formation.thcr.exo.ExoArrayList1;
import com.formation.thcr.exo.ExoTableau1;

public class MainActiveFormationParis {

	public static void main(String[] args) {
		MainActiveFormationParis main = new MainActiveFormationParis();
		main.init();
	}

	private void init() {
		ExoArrayList1 exo = new ExoArrayList1();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1 = exo.remplirTableau(3, 10, 2);
		System.out.println(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2 = exo.remplirTableau(0, 20, 3);
		System.out.println(list2);
		System.out.println(exo.insererUnTableauDansUnAutreAvecRemplacement(list1, 3, list2));
		System.out.println(exo.rotationTableau(list1, -2));

	}

	private void init2() {
		ExoTableau1 exo = new ExoTableau1();
		System.out.println(Arrays.toString(exo.remplirTableau(0x7F_FF_FF_FF, 10, 2)));
		int[] tab = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int i1 = 3, i2 = 8;
		System.out.println(Arrays.toString(tab));
		System.out.println(Arrays.toString(exo.intervertirDeuxElementsTableau(tab, i1, i2)));
		int[] tab2 = { 1, 4, 6, 2, 4, 6 };
		int p = 3, a = 8;
		System.out.println(Arrays.toString(tab2));
		System.out.println(Arrays.toString(exo.insererUnElementDansTableau(tab2, p, a)));
		int[] tab3 = { 1, 4, 6, 2, 4, 7 };
		int[] tab4 = { 4, 9, 0 };
		p = 2;
		System.out.println(Arrays.toString(tab3));
		System.out.println(Arrays.toString(tab4));
		System.out.println("-----");
		System.out.println(Arrays.toString(exo.insererUnTableauDansUnAutreAvecRemplacement(tab3, p, tab4)));
		System.out.println("-----");
		int[] tab5 = { 22, 11, 0, 77, 88, 99 };
		int[] tab6 = { 3, 4, 5, 6 };
		p = 2;
		System.out.println(Arrays.toString(tab5));
		System.out.println(Arrays.toString(tab6));
		System.out.println("-----");
		System.out.println(Arrays.toString(exo.insererUnTableauDansUnAutreAvecRemplacement(tab5, p, tab6)));
		System.out.println("-----");
		int[] tab7 = { 1, 4, 6, 2, 4, 6 };
		p = 2;
		System.out.println(Arrays.toString(tab7));
		System.out.println(Arrays.toString(exo.rotationTableau(tab7, p)));
		p = -4;
		System.out.println(Arrays.toString(tab7));
		System.out.println(Arrays.toString(exo.rotationTableau(tab7, p)));
	}
}
