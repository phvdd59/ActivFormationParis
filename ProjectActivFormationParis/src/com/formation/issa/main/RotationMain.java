package com.formation.issa.main;

import com.formation.issa.exo.ExoTableau1;

public class RotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotationMain exoRotation=new RotationMain();
		exoRotation.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		
		ExoTableau1 exoRotation=new ExoTableau1();
		
		int tabResultat[]={1,4,6,2,4,6};
		
		int positionOrigine=1;
		
		int[] tabFinal=exoRotation.rotationTableau(tabResultat,positionOrigine);
		System.out.println(tabFinal);
		
	}

}
