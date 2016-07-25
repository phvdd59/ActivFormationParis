package com.formation.issa.main;

import java.util.Arrays;

import com.formation.issa.exo.ExoTableau2;

public class MainRallongementTableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainRallongementTableau exotab2Ral=new MainRallongementTableau();
		exotab2Ral.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau2 rltab2=new ExoTableau2();
		int[]tabi={1,4,6,2,4,6};
		int a=8;
		int[]tabiF=rltab2.rallongerTableauDeUnElement(tabi, a);
		Arrays.sort(tabiF);
		
	}

}
