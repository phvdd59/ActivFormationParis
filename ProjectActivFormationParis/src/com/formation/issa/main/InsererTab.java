package com.formation.issa.main;

import com.formation.issa.exo.ExoTableau1;
//import com.formation.issa.exo.tab;

public class InsererTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsererTab tableau3=new InsererTab();
		tableau3.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau1 exoInsertion=new ExoTableau1();
		
		
	
		int tabResultat[]={1, 4, 6, 2, 4, 6,9,5};
		int p=7;
		int a=12;
		
		int[] tabres=exoInsertion.insererUnElementDansTableau(tabResultat, p, a);
			
		
		System.out.println(tabres);
	}

}
