package com.formation.issa.main;

import java.util.Arrays;

import com.formation.issa.exo.ExoTableau1;

public class MainInsertTableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainInsertTableau tabInsert=new MainInsertTableau();
		tabInsert.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau1 tabInsertion=new ExoTableau1();
		
		int[]tabF={1,4,6,2,4,7};
		int p=2;
		int[]tab1={4,9,0};
		
		int[]tabFinalInsert=tabInsertion.insererUnTableauDansUnAutreAvecRemplacement(tabF, p, tab1);
		
		System.out.println(Arrays.toString(tabFinalInsert));
		
	}

}
