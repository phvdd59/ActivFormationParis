package com.formation.issa.main;

import com.formation.issa.exo.ExoTableau1;

public class InsererTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsererTab tableau3=new InsererTab();
		tableau3.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau1 exoInsertion=new ExoTableau1();
		int[]tab1={1,4,6,2,4,6};
		int[]tab2={4,6};
		tab1=new int[5];
		tab2=new int[1];
		
		int[]tab=new int[6];
		System.out.println(exoInsertion.insererUnElementDansTableau(tab, 3, 8));
	}

}
