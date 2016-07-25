package com.formation.issa.main;

import java.util.Arrays;

import com.formation.issa.exo.ExoTableau2;

public class MainExoTableau2inversionTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainExoTableau2inversionTab tab2Inverse=new MainExoTableau2inversionTab();
		tab2Inverse.init();
	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau2 inversion=new ExoTableau2();
		int[] tab1={1,4,6,-5,7,5};
		int[]tabA=inversion.inverserTableau(tab1);
		System.out.println(Arrays.toString(tabA));
		
	}

}
