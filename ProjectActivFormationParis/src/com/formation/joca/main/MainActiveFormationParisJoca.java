package com.formation.joca.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.ambr.ctr.ExoAlgo5;
import com.formation.joca.exo.CleDico;
import com.formation.joca.exo.Dico;
import com.formation.joca.exo.ExoAlgo1;
import com.formation.joca.exo.ExoAlgo2;
import com.formation.joca.exo.ExoAlgo3;
import com.formation.joca.exo.ExoArrayList1;
import com.formation.joca.exo.ExoException1;
import com.formation.joca.exo.ExoFlux1;
import com.formation.joca.exo.ExoSimple;
import com.formation.joca.exo.ExoTableau1;
import com.formation.joca.exo.ExoTableau2;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Mouvement;
import com.formation.phva.exo.Terme;

public class MainActiveFormationParisJoca {

	public static void main(String[] arg) {
		MainActiveFormationParisJoca test = new MainActiveFormationParisJoca();
		test.init13();
	}

	private void init13() {
		// ExoAlgo6 exo6 = new ExoAlgo6();
		int[] tab = { 1, 4, 7, 8, 4, 3, 7, 2, 8, 9, 2, 6, 3, 4, 1, 7, 9, 1, 1, 2 };
		// int result = exo6.solution(tab, 2, 3);
		// System.out.println(result);

	}

	private void init12() {
		ExoAlgo5 exo = new ExoAlgo5();
		String[] tab = { "123456001", "123456002", "123456001", "456789001", "123456003", "123456001", "123456003",
				"123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510",
				"456789510", "789456245", "123456001" };
		String[] tabnull = null;
		String[] tab2 = exo.solution(tab, "456789", 2);
		for (int i = 0; i < tab2.length; i++) {
			System.out.println(tab2[i]);
		}
	}

	private void init10() {
		ExoFlux1 exo10 = new ExoFlux1();
		exo10.saisie();
		for (int i = 0; i < exo10.size(); i++) {
			System.out.println(exo10.get(i).toString());
		}

		// exo10.recup(); for (int i = 0; i < exo10.size(); i++) {
		// System.out.println(exo10.get(i).toString()); }

	}

	private void init9() {

		ExoException1 exo9 = new ExoException1();

		Terme terme1 = new Terme("chat", new Point(0, 0), false);
		Terme terme2 = new Terme("et", new Point(1, 2), true);
		Terme terme3 = new Terme("asci", new Point(2, 0), true);
		Terme terme4 = new Terme("corp", new Point(0, 0), true);
		Terme terme5 = new Terme("tete", new Point(3, 0), true);
		Terme terme6 = new Terme("ect", new Point(1, 2), false);

		ArrayList<Terme> lst = new ArrayList<Terme>();
		lst.add(terme1);
		lst.add(terme2);
		lst.add(terme3);
		lst.add(terme4);
		lst.add(terme5);
		lst.add(terme6);

		char[][] tab = new char[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tab[i][j] = ' ';
			}
		}

		try {
			tab = exo9.solution(4, 4, lst);
		} catch (CruciException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(" ");
			for (int j = 0; j < 4; j++) {
				System.out.print(tab[i][j]);
			}
		}
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

		// tabTest = exo2.intervertirDeuxElementsTableau(tabTest, 2, 5);
		// this.afficherTableau(tabTest);

		// tabTest = exo2.insererUnElementDansTableau(tabTest, 3, 5);
		// this.afficherTableau(tabTest);

		int[] tab2 = { 2, 8 };
		tabTest = exo2.insererUnTableauDansUnAutreAvecRemplacement(tabTest, 2000, tab2);
		this.afficherTableau(tabTest);

		tabTest = exo2.rotationTableau(tabTest, 2);
		// this.afficherTableau(tabTest);
	}

	private void init3() {
		int[] tabTest = { 1, 7, 8, 2, 4, 6 };
		int[] tabTest2 = { 4, 9, 7 };
		int[] tabNull;
		tabNull = null;
		ExoTableau2 exo3 = new ExoTableau2();
		this.afficherTableau(tabTest);
		this.afficherTableau(tabTest2);
		int[] tabResult;
		int[][] tabResult2;
		// tabResult = exo3.inverserTableau(tabTest);
		// this.afficherTableau(tabResult);

		// tabResult=exo3.rallongerTableauDeUnElement(null, -9);
		// this.afficherTableau(tabResult);

		tabResult = exo3.insererUnTableauDansUnAutre(tabTest, 2, tabTest2);
		this.afficherTableau(tabResult);

		/*
		 * tabResult2 = exo3.changerDimensionTableau(tabTest, 3); for (int i =
		 * 0; i < 2; i++) { System.out.println(" "); for (int j = 0; j < 3; j++)
		 * { System.out.print(tabResult2[i][j]); } }
		 */

		/*
		 * tabResult = exo3.tabBaseDeux(75189); afficherTableau(tabResult);
		 * tabResult = exo3.tabBaseDeux(Integer.MIN_VALUE);
		 * afficherTableau(tabResult); tabResult = exo3.tabBaseDeux(-75189);
		 * afficherTableau(tabResult);
		 */

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
		ArrayList<Integer> list3 = new ArrayList<Integer>();

		/*
		 * ArrayList<Integer> list3 = exo4.remplirTableau(8, 16, -8);
		 * this.afficherListe(list3);
		 * 
		 * list3.clear(); list3 = exo4.intervertirDeuxElementsTableau(list1, 2,
		 * 5); this.afficherListe(list3);
		 * 
		 * list3.clear(); list3 = exo4.insererUnElementDansTableau(list1, 7, 5);
		 * this.afficherListe(list3);
		 * 
		 * list3.clear(); list3 =
		 * exo4.insererUnTableauDansUnAutreAvecRemplacement(list1, -7, list2);
		 */this.afficherListe(list3);

		list3.clear();
		list3 = exo4.rotationTableau(list1, -4);
		this.afficherListe(list3);
	}

	private void init5() {
		ExoAlgo1 exo5 = new ExoAlgo1();
		int[] tab = { -1, 3, -4, 5, 1, -6, 2, 1 };
		int p1 = exo5.solution(tab);
		int p2 = exo5.solution2(tab);
		ArrayList<Integer> liste = exo5.solution3(tab);
		System.out.println(p1 + " " + p2 + " " + liste);
		System.out.println(exo5.solution(null));
	}

	private void init6() {
		ExoAlgo2 exo6 = new ExoAlgo2();
		System.out.println(exo6.solution(21474642));
	}

	private void init7() {
		ExoAlgo3 exo7 = new ExoAlgo3();
		ArrayList<Mouvement> solution = new ArrayList<Mouvement>();
		solution = exo7.solution(solution, 4, "a", "b", "c");
		for (int i = 0; i < solution.size(); i++) {
			System.out.println(solution.get(i));
		}
		System.out.println("\u00a9");
	}

	private void init8() {
		Dico exo8 = new Dico();
		String texte = "bbnjour bbnjour comment allez vous.le le lii lii le le le le la la li il il il te te te la li li lz";
		exo8.dico(texte);
		// System.out.println(exo8.ranger(texte));

		// Mot mot1 = new Mot("chat");
		// Mot mot2 = new Mot("chat");
		// Mot mot3 = new Mot("chien");

		// System.out.println(mot1.equals(mot2));
		// .out.println(mot1.equals(mot3));

		// exo8.ranger(texte);

		System.out.println(exo8.traitementTexte(texte));

		System.out.println(exo8.getListeMot("l", 3));
		System.out.println(exo8.get(new CleDico("l", 3)).get(0).getNb());

	}
}
