package com.formation.issa.main;

import com.formation.issa.exo.ExoTableau1;

public class MainExoTableau1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainExoTableau1 tableau1=new MainExoTableau1();
		tableau1.init();
		
		

	}

	private void init() {
		ExoTableau1 exoTableau1=new ExoTableau1();
		
		
		System.out.println(exoTableau1.remplirTableau(7, -6, 3));
		
		
	}

}
