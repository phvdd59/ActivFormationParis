package com.formation.issa.main;

import java.util.ArrayList;

import com.formation.issa.exo.ExoArrayList1;

public class MainInterversionArrayList {

	public static void main(String[] args) {
		MainInterversionArrayList exoArrayListInverse = new MainInterversionArrayList();
		exoArrayListInverse.init();

	}

	private void init() {
		ExoArrayList1 arrayInverse = new ExoArrayList1();
		ArrayList<Integer> tabi = new ArrayList<Integer>();
		tabi.add(new Integer(7));
		tabi.add(new Integer(10));
		tabi.add(new Integer(13));
		tabi.add(new Integer(16));
		tabi.add(new Integer(19));
		tabi.add(new Integer(21));
		tabi.add(new Integer(24));
		tabi.add(new Integer(27));
		tabi.add(new Integer(30));
		int i1 = 2;
		int i2 = 7;
		System.out.println(arrayInverse.intervertirDeuxElementsTableau(tabi, i1, i2));

	}

	

}
