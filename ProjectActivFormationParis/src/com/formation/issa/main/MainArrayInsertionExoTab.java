package com.formation.issa.main;

import java.util.ArrayList;

import com.formation.issa.exo.ExoArrayList1;

public class MainArrayInsertionExoTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainArrayInsertionExoTab exoInsertArray = new MainArrayInsertionExoTab();
		exoInsertArray.init();

	}

	private void init() {
		ExoArrayList1 exotabInsert = new ExoArrayList1();
		ArrayList<Integer> listeResultat = new ArrayList<Integer>();

		listeResultat.add(new Integer(1));
		listeResultat.add(new Integer(4));
		listeResultat.add(new Integer(6));
		listeResultat.add(new Integer(2));
		listeResultat.add(new Integer(4));
		listeResultat.add(new Integer(6));
		int p = 3;
		int a = 8;

		System.out.println(exotabInsert.insererUnElementDansTableau(listeResultat, p, a));
	}

}
