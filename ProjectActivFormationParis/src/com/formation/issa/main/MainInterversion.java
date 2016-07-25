package com.formation.issa.main;

import java.util.Arrays;

import com.formation.issa.exo.ExoTableau1;

public class MainInterversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainInterversion exoInterversion=new MainInterversion();
		exoInterversion.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoTableau1 interver=new ExoTableau1();
		
		int tab1[]={7,10,13,16,19,21,24,27,30};
		int i1=2;
		int i2=7;
		
		int[]tabFinal=interver.intervertirDeuxElementsTableau(tab1, i1, i2);
		System.out.println(Arrays.toString(tabFinal));
	}

}
