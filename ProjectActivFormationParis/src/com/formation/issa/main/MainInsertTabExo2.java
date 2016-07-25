package com.formation.issa.main;

import java.util.Arrays;

import com.formation.issa.exo.ExoTableau2;

public class MainInsertTabExo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainInsertTabExo2 insertTabExo2=new MainInsertTabExo2();
		insertTabExo2.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau2 inTabExo2=new ExoTableau2();
		int[]tabF={1,4,6,2,4,6};
		int[]tab1={4,9,0};
		int p=2;
		int[]tabF2=inTabExo2.insererUnTableauDansUnAutre(tabF, p, tab1);
		Arrays.sort(tabF2);
		
	}

}
