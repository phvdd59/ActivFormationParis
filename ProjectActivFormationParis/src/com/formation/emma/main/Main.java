package com.formation.emma.main;

import java.util.ArrayList;

import com.formation.emma.exo.ExoArrayList1;
import com.formation.emma.exo.ExoSimple;
import com.formation.emma.exo.ExoTableau1;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();
		main.init();

	}

	private void init() {
		int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exo = new ExoSimple();

		int somme = exo.sumTableau(tab);
		System.out.println(somme);

		System.out.println("exo1 tableau1");
		int d = 3;
		int n = 16;
		int p = -8;
		ExoTableau1 exoTableau1 = new ExoTableau1();
		int[] tableau = exoTableau1.remplirTableau(d, n, p);

		//faire if car boucle for ne fonctionne pas si tableau nul
		if (tableau == null) {
			System.out.println(tableau);
		} else {
			for (int i = 0; i < tableau.length; i++) {
				System.out.println(tableau[i]);
			}
		}

		System.out.println("exo2 tableau1");

		int[] tab1 = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int i1 = 3;
		int i2 = 8;
		ExoTableau1 exo2Tableau1 = new ExoTableau1();
		int[] tableau2 = exo2Tableau1.intervertirDeuxElementsTableau(tab1, i1, i2);
		if (tableau2 == null) {
			System.out.println(tableau2);
		} else {
			for (int i = 0; i < tableau2.length; i++) {
				System.out.println(tableau2[i]);
			}
		}

		System.out.println("exo3 tableau1");
		int[] tab2 = { 1, 4, 6, 2, 4, 6 };
		int a = 3;
		int p1 = 3;
		ExoTableau1 exo3Tableau1 = new ExoTableau1();
		int[] tableau3 = exo3Tableau1.insererUnElementDansTableau(tab2, p1, a);
		if (tableau3 == null) {
			System.out.println(tableau3);
		} else {
			for (int i = 0; i < tableau3.length; i++) {
				System.out.println(tableau3[i]);
			}
		}

		System.out.println("exo4 tableau1");
		int[] tab3 = { 1, 4, 6, 2, 4, 7 };
		int[] tab4 = { 4, 9, 0 };
		int p3 = 3;
		ExoTableau1 exo4Tableau1 = new ExoTableau1();
		int[] tableau4 = exo4Tableau1.insererUnTableauDansUnAutreAvecRemplacement(tab3, p3, tab4);
		if (tableau4 == null) {
			System.out.println(tableau4);
		} else {
			for (int i = 0; i < tableau4.length; i++) {
				System.out.println(tableau4[i]);
			}
		}

		System.out.println("exo5 tableau1");
		int[] tab6 = { 1, 4, 6, 2, 4, 6 };
		int p4 = 3;
		ExoTableau1 exo5Tableau1 = new ExoTableau1();
		int[] tableau5 = exo5Tableau1.rotationTableau(tab6, p4);
		if (tableau5 == null) {
			System.out.println(tableau5);
		} else {
			for (int i = 0; i < tableau5.length; i++) {
				System.out.println(tableau5[i]);
			}
		}

		System.out.println("exo arrayliste");

		System.out.println("exo1 ");
		int dl = 3;
		int nl = 5;
		int pl = 4;
		ExoArrayList1 exoList1 = new ExoArrayList1();
		System.out.println(exoList1.remplirTableau(dl, nl, pl));

		System.out.println("exo2 ");
		ArrayList listTabl = new ArrayList();
		int[] tabl = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int i1l = -3;
		int i2l = 8;
		for (int j = 0; j < tabl.length; j++) {
			listTabl.add(tabl[j]);
		}
		System.out.println(listTabl);
		ExoArrayList1 exoList2 = new ExoArrayList1();
		System.out.println(exoList2.intervertirDeuxElementsTableau(listTabl, i1l, i2l));

		System.out.println("exo3 ");
		ArrayList listTab2l = new ArrayList();
		int[] tab2l = { 1, 4, 6, 2, 4, 6 };
		int al = 6;
		int p1l = 3;
		for (int j = 0; j < tab2l.length; j++) {
			listTab2l.add(tab2l[j]);
		}
		ExoArrayList1 exoList3 = new ExoArrayList1();
		System.out.println(exoList3.insererUnElementDansTableau(listTab2l, p1l, al));

		System.out.println("exo4 ");
		ArrayList listTab3l = new ArrayList();
		ArrayList listTab4l = new ArrayList();
		int[] tab3l = { 1, 4, 6, 2, 4, 7 };
		int[] tab4l = { 4, 9, 0 };
		int p3l = 3;
		for (int j = 0; j < tab3l.length; j++) {
			listTab3l.add(tab3l[j]);
		}
		for (int j = 0; j < tab4l.length; j++) {
			listTab4l.add(tab4l[j]);
		}
		ExoArrayList1 exoList4 = new ExoArrayList1();
		System.out.println(exoList4.insererUnTableauDansUnAutreAvecRemplacement(listTab3l, p3l, listTab4l));

		System.out.println("exo5 ");
		ArrayList listTab5l = new ArrayList();
		int[] tab5l = { 1, 4, 6, 2, 4, 6 };
		int p4l = 1;
		for (int j = 0; j < tab5l.length; j++) {
			listTab5l.add(tab5l[j]);
		}
		ExoArrayList1 exoList5 = new ExoArrayList1();
		System.out.println(exoList5.rotationTableau(listTab5l, p4l));

	}
}
