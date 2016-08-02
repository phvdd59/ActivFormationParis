package com.formation.jeci.main;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.jeci.exo.CleDico;
import com.formation.jeci.exo.Dico;
import com.formation.jeci.exo.ExoTableau1;
import com.formation.jeci.exo.Mot;

public class Main {

	public static void main(String[] args) {
		Main tab = new Main();
//		tab.init();
		tab.init2();
		

	}

	private void init2() {
		
		Dico test=new Dico();
	String test1="SAlut a les thunes yya yya olive lès t'as reçu les  les les thùnés?";
	
	test.ranger(test1);
	ArrayList<String> tralala = test.getListeMot("l", 5);
	System.out.println(tralala);
	
//	TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<Integer,ArrayList<Integer>>();
//		for (int j = 1; j <= 5; j++) {
//		int key=j;
//			ArrayList<Integer> dico = new ArrayList<Integer>();
//
//			for (int k = 0; k < 10; k++) {
//				
//					dico.add(k);
//					
//				}map.put(key, dico);
//				
//			}System.out.print(map);
//			
//	
//
	}
		
	


	private void init() {
		// ExoSimple exo1 = new ExoSimple();
		// int tableau1[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		// System.out.println(exo1.sumTableau(tableau1));
		ExoTableau1 exo2 = new ExoTableau1();
		exo2.remplirTableau(2, 5, 6);
		// int []tab={0,1,2,3,4,5,6,7,8,9};
		// int[]tab1={6,6,6,6};
		// exo2.intervertirDeuxElementsTableau(tab, 3, 4);
		// exo2.insererUnElementDansTableau(tab, 5, 10);
		// exo2.insererUnTableauDansUnAutreAvecRemplacement(tab, 3, tab1);
		// exo2.rotationTableau(tab, 2);
	}
}
