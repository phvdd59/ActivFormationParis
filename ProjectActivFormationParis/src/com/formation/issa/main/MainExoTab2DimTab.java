package com.formation.issa.main;

import com.formation.issa.exo.ExoTableau2;

public class MainExoTab2DimTab {

	public static void main(String[] args) {
		MainExoTab2DimTab tab2D=new MainExoTab2DimTab();
		tab2D.init();

	}

	private void init() {
		ExoTableau2 exoTab2D =new ExoTableau2();
		int tabF[]={1,7,8,2,4,6};
		int d=3;
		System.out.println(exoTab2D.changerDimensionTableau(tabF, d));
		
	}

}
