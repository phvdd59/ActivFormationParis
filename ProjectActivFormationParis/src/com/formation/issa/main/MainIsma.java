package com.formation.issa.main;

import com.formation.issa.exo.ExoSimple;

public class MainIsma {

	public static void main(String[] args) {
		MainIsma tableau=new MainIsma();
		tableau.init();
		

		

	}

	private void init() {
	ExoSimple exoSimple=new ExoSimple();

	int[]tab={1,5,7,6,8,9,4,2,3};
	System.out.println(exoSimple.sumTableau(tab));
		
	}

}
