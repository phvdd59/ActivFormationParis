package com.formation.emma.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.formation.emma.exo.ExoAlgo1;
import com.formation.emma.exo.ExoArrayList1;
import com.formation.emma.exo.ExoSimple;
import com.formation.emma.exo.ExoTableau1;
import com.formation.emma.exo.ExoTableau2;

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
		int p3l = 4;
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
		int p4l = -10;
		for (int j = 0; j < tab5l.length; j++) {
			listTab5l.add(tab5l[j]);
		}
		ExoArrayList1 exoList5 = new ExoArrayList1();
		System.out.println(exoList5.rotationTableau(listTab5l, p4l));

		System.out.println("exo tableau2");
		System.out.println("exo1 ");
		int[] tab10 = { 1, 4, 6, -5, 7, 5 };
		ExoTableau2 exo1Tableau2 = new ExoTableau2();
		int[] tableau10 = exo1Tableau2.inverserTableau(tab10);
		if (tableau10 == null) {
			System.out.println(tableau10);
		} else {
			for (int i = 0; i < tableau10.length; i++) {
				System.out.println(tableau10[i]);
			}
		}

		System.out.println("exo2 ");
		int[] tab12 = { 1, 4, 6, 2, 4, 6 };
		int z = 8;
		ExoTableau2 exo2Tableau2 = new ExoTableau2();
		int[] tableau12 = exo2Tableau2.rallongerTableauDeUnElement(tab12, z);
		if (tableau12 == null) {
			System.out.println(tableau12);
		} else {
			for (int i = 0; i < tableau12.length; i++) {
				System.out.println(tableau12[i]);
			}
		}

		System.out.println("exo3 ");
		int[] tab13 = { 1, 4, 6, 2, 4, 6 };
		int[] tab14 = { 4, 9, 0 };
		int y = 2;
		ExoTableau2 exo3Tableau2 = new ExoTableau2();
		int[] tableau13 = exo3Tableau2.insererUnTableauDansUnAutre(tab13, y, tab14);
		if (tableau13 == null) {
			System.out.println(tableau13);
		} else {
			for (int i = 0; i < tableau13.length; i++) {
				System.out.println(tableau13[i]);
			}
		}

		System.out.println("exo4 ");
		int[] tab15 = { 1, 7, 8, 2, 4, 6 };
		int x = 3;
		ExoTableau2 exo4Tableau2 = new ExoTableau2();
		int[][] tableau14 = exo4Tableau2.changerDimensionTableau(tab15, x);
		if (tableau14 == null) {
			System.out.println(tableau14);
		} else {
			for (int i = 0; i < tab15.length / x; i++) {
				//for (int j = 0; j < tableau14[0].length ; j++) {

				//	System.out.print(tableau14[i][j]+",");
				//}
				//System.out.println();
				System.out.println(Arrays.toString(tableau14[i]));
			}
		}

		System.out.println("exo5 ");
		int nombre = -Integer.MAX_VALUE;
		ExoTableau2 binaire = new ExoTableau2();
		int[] valeurBinaire = binaire.tabBaseDeux(nombre);
		if (valeurBinaire == null) {
			System.out.println(valeurBinaire);
		} else {
			for (int i = 0; i < valeurBinaire.length; i++) {
				System.out.print(valeurBinaire[i]);
			}
		}
		System.out.println(" ");
		System.out.println("exoalgo1");
		int[] tabAlgo1 = {1,2,3, 6 , -3};
		ExoAlgo1 algo = new ExoAlgo1();
		int pAlgo = algo.solution(tabAlgo1);
		System.out.println(pAlgo);

		System.out.println("tableau à deux dimensions");
		int[][] tableau2D = new int[3][4];
		int[][] tableau2D2 = { { 1, 2, 3, 4, }, { 50, 6, 7, -9 }, { 7, 8, 3, 6 } }; // meme type de tableau
		int[] tableau1D = tableau2D2[0];
		for (int i = 0; i < tableau1D.length; i++) {
			System.out.println(tableau1D[i]);
		}
		int[][][] tableau3D = new int[4][2][3];

		// 26 lettres alphabets
		//taille tableau 27
		// tient sur 5 bytes
		// faire toutes les lettres en binaire
	}
}
