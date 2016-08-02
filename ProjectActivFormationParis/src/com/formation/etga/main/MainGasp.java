package com.formation.etga.main;

import java.util.ArrayList;

import com.formation.etga.exo.Dico;
import com.formation.etga.exo.ExoAlgo3;
import com.formation.phva.exo.Mouvement;

public class MainGasp {

	public static void main(String[] args) {
		MainGasp mainGasp = new MainGasp();
		//		mainGasp.init1();
		//		mainGasp.init2();
		//		mainGasp.init3();
		//		mainGasp.init4();
		//		mainGasp.init5();
		mainGasp.init6();
		mainGasp.init7();
	}

	//	private void init1() {
	//		ExoTableau1 exoTableau1 = new ExoTableau1();
	//		int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	//		int[] tab1 = { 10, 11, 12 };
	//
	//		int[] tabFinal1 = exoTableau1.remplirTableau(7, 5, 3);
	//		if (tabFinal1 != null) {
	//			for (int i = 0; i < tabFinal1.length; i++) {
	//				System.out.print(tabFinal1[i] + ", ");
	//			}
	//		}
	//		System.out.print("\n");
	//
	//		int[] tabFinal2 = exoTableau1.intervertirDeuxElementsTableau(tab, 3, 6);
	//		for (int i = 0; i < tabFinal2.length; i++) {
	//			System.out.print(tabFinal2[i] + ", ");
	//		}
	//		System.out.print("\n");
	//
	//		int[] tabFinal3 = exoTableau1.insererUnElementDansTableau(tab, 3, 6);
	//		for (int i = 0; i < tabFinal3.length; i++) {
	//			System.out.print(tabFinal3[i] + ", ");
	//		}
	//		System.out.print("\n");
	//
	//		int[] tabFinal4 = exoTableau1.insererUnTableauDansUnAutreAvecRemplacement(tab, 2, tab1);
	//		for (int i = 0; i < tabFinal4.length; i++) {
	//			System.out.print(tabFinal4[i] + " ");
	//		}
	//		System.out.print("\n");
	//
	//		int[] tabFinal5 = exoTableau1.rotationTableau(tab, 2);
	//		for (int i = 0; i < tabFinal5.length; i++) {
	//			System.out.print(tabFinal5[i] + ", ");
	//		}
	//
	//		System.out.println("");
	//		System.out.println("");
	//	}
	//
	//	private void init2() {
	//		ExoArrayList1 exoArrayList1 = new ExoArrayList1();
	//		Integer[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	//		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(tab));
	//		Integer[] tab1 = { 10, 11, 12 };
	//		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(tab1));
	//
	//		ArrayList<Integer> listFinal1 = exoArrayList1.remplirTableau(7, 5, 3);
	//		System.out.print(listFinal1 + ", ");
	//		System.out.print("\n");
	//
	//		ArrayList<Integer> listFinal2 = exoArrayList1.intervertirDeuxElementsTableau(list, 3, 6);
	//		System.out.print(listFinal2 + ", ");
	//		System.out.print("\n");
	//
	//		ArrayList<Integer> listFinal3 = exoArrayList1.insererUnElementDansTableau(list, 3, 6);
	//		System.out.print(listFinal3 + ", ");
	//		System.out.print("\n");
	//
	//		ArrayList<Integer> listFinal4 = exoArrayList1.insererUnTableauDansUnAutreAvecRemplacement(list, 2, list1);
	//		System.out.print(listFinal4 + " ");
	//		System.out.print("\n");
	//
	//		ArrayList<Integer> listFinal5 = exoArrayList1.rotationTableau(list, 2);
	//		System.out.print(listFinal5 + ", ");
	//		System.out.print("\n");
	//
	//		System.out.println("");
	//		System.out.println("");
	//	}
	//
	//	private void init3() {
	//		ExoTableau2 exoTableau2 = new ExoTableau2();
	//		int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	//		int[] tab1 = { 10, 11, 12 };
	//		int a = 3; // valeur à ajouter à la fin
	//		int p = 3; // position à laquelle le tab1 doit être inserer dans tab
	//		int d = 3; // en combien on divise le tab
	//		int v = 15; // nombre à convertir en binaire
	//
	//		int[] tabFinal1 = exoTableau2.inverserTableau(tab);
	//		for (int i = 0; i < tabFinal1.length; i++) {
	//			System.out.print(tabFinal1[i] + ", ");
	//		}
	//		System.out.print("\n");
	//
	//		int[] tabFinal2 = exoTableau2.rallongerTableauDeUnElement(tab, a);
	//		for (int i = 0; i < tabFinal2.length; i++) {
	//			System.out.print(tabFinal2[i] + ", ");
	//		}
	//		System.out.print("\n");
	//
	//		int[] tabFinal3 = exoTableau2.insererUnTableauDansUnAutre(tab, p, tab1);
	//		for (int i = 0; i < tabFinal3.length; i++) {
	//			System.out.print(tabFinal3[i] + ", ");
	//		}
	//		System.out.print("\n");
	//
	//		int[][] tabFinal4 = exoTableau2.changerDimensionTableau(tab, d);
	//		for (int i = 0; i < (tab.length / d); i++) {
	//			for (int j = 0; j < d; j++) {
	//				System.out.print(tabFinal4[i][j]);
	//			}
	//			System.out.print("\n");
	//		}
	//
	//		int[] tabFinal5 = exoTableau2.tabBaseDeux(v);
	//		for (int i = 0; i < tabFinal5.length; i++) {
	//			System.out.print(tabFinal5[i] + " ");
	//		}
	//
	//		System.out.println("");
	//		System.out.println("");
	//
	//	}
	//
	//	private void init4() {
	//		ExoAlgo1 exoAlgo1 = new ExoAlgo1();
	//		int[] tab = { -1, 3, -4, 5, 1, -6, 2, 1 };
	//		int solution1 = exoAlgo1.solution(tab);
	//		System.out.print(solution1);
	//
	//		System.out.println("");
	//		System.out.println("");
	//	}
	//
	//	private void init5() {
	//		ExoAlgo2 exoAlgo2 = new ExoAlgo2();
	//		int n = 2147483647;
	//		int solution2 = exoAlgo2.solution(n);
	//		System.out.println(solution2);
	//	}

	private void init6() {

		ExoAlgo3 exoAlgo3 = new ExoAlgo3();
		ArrayList<Mouvement> lst = new ArrayList<Mouvement>();
		lst = exoAlgo3.solution(lst, 4, "A", "B", "C");
		for (int i = 0; i < lst.size(); i++) {
			System.out.println("D�placement " + (i + 1) + " : " + lst.get(i).toString());
		}
		System.out.println("");
		System.out.println("");
	}

	private void init7() {
		Dico dico = new Dico();
		String testText = "Vous savez, moi je ne crois pas qu'il y ait de bonne ou de mauvaise situation. Moi, si je devais résumer ma vie aujourd’hui avec vous, je dirais que c’est d’abord des rencontres. Des gens qui m’ont tendu la main, peut-être à un moment où je ne pouvais pas, où j’étais seul chez moi. Et c’est assez curieux de se dire que les hasards, les rencontres forgent une destinée... Parce que quand on a le goût de la chose, quand on a le goût de la chose bien faite, le beau geste, parfois on ne trouve pas l’interlocuteur en face je dirais, le miroir qui vous aide à avancer. Alors ça n’est pas mon cas, comme je disais là, puisque moi au contraire, j’ai pu : et je dis merci à la vie, je lui dis merci, je chante la vie, je danse la vie... je ne suis qu’amour ! Et finalement, quand beaucoup de gens aujourd’hui me disent « Mais comment fais-tu pour avoir cette humanité ?», et bien je leur réponds très simplement, je leur dis que c’est ce goût de l’amour ce goût donc qui m’a poussé aujourd’hui à entreprendre une construction mécanique, mais demain qui sait ? Peut-être simplement à me mettre au service de la communauté, à faire le don, le don de soi...";
		dico.ranger(testText);
		for (int i = 1; i < 10; i++) {
			ArrayList<String> lst = dico.getListeMot("e", i);
			if (lst.isEmpty() == true) {
			} else {
				System.out.println("mots de " + i + " lettres : " + lst.toString());
			}
		}
	}
}
