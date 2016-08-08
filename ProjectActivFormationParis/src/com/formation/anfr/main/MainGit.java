package com.formation.anfr.main;

import java.util.ArrayList;

import com.formation.anfr.exo.ExoAlgo2;
import com.formation.anfr.exo.ExoAlgo3;
import com.formation.anfr.exo.ExoArrayList1;
import com.formation.phva.exo.Mouvement;

public class MainGit {

	public static void main(String[] args) {
		MainGit mainGit = new MainGit();
		mainGit.init();

	}

	public void init() {
		ExoAlgo3 exoAlgo3 = new ExoAlgo3();
		ArrayList<Mouvement> lst = new ArrayList<Mouvement>();
		lst = exoAlgo3.solution(lst, 3, "A", "B","C");
		System.out.println(lst);
	}
	
	public void init3() {
		ExoAlgo2 exoAlgo2 = new ExoAlgo2();
		int sol = exoAlgo2.solution(2147483647);
		System.out.println(sol);

	}

	public void init2() {
		int[] tab = {};
		System.out.println(tab.length);
		ExoArrayList1 exo = new ExoArrayList1();
		ArrayList<Integer> premiereListe;
		int d = -2 % 10;
		premiereListe = exo.remplirTableau(1, 10, 1);
		ArrayList<Integer> secondeListe = exo.remplirTableau(20, 4, 10);
		ArrayList<Integer> troisiemeListe = exo.remplirTableau(0, 4, 10);
		ArrayList<Integer> Liste0 = exo.intervertirDeuxElementsTableau(premiereListe, 5, 8);
		ArrayList<Integer> Liste1 = exo.insererUnElementDansTableau(premiereListe, 8, 152);
		ArrayList<Integer> Liste2 = exo.insererUnTableauDansUnAutreAvecRemplacement(premiereListe, 5, secondeListe);
		ArrayList<Integer> Liste3 = exo.rotationTableau(premiereListe, 5);

		System.out.println("Intervertir : " + Liste0);
		System.out.println("Inserer 1 : " + Liste1);
		System.out.println("Inserer Tab :" + Liste2);
		System.out.println("Rotation :" + Liste3);
		System.out.println("");
	}

}
