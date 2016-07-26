package com.formation.issa.main;

import com.formation.issa.exo.ExoTableau2;

public class MainExoTab2DimTab {

	public static void main(String[] args) {
		MainExoTab2DimTab tab2D=new MainExoTab2DimTab();
		tab2D.init();

	}

	private void init() {
		int[] tabOrigine={5,4,6,7,8};
		
//		int[][] tabDeux={{1,2,3,4},{8,3,6,2},{5,8,12,-3}};
//		System.out.println(tabOrigine.length);
//		System.out.println(tabDeux.length);
//		System.out.println(tabDeux[0].length);
		
		
		ExoTableau2 exoTab2D =new ExoTableau2();
		int tabF[]={1,7,8,2,4,6};
		int d=3;
		System.out.println(exoTab2D.changerDimensionTableau(tabF, d));
		
	}

}
