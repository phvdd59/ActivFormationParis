package com.formation.issa;

import com.formation.issa.exo.ExoTableau2;

public class MainExoBinaire {

	public static void main(String[] args) {
		MainExoBinaire tabBinaire=new MainExoBinaire();
		tabBinaire.init();

	}

	private void init() {
	ExoTableau2 exoBin=new ExoTableau2();
	int v=18;
	System.out.println(exoBin.tabBaseDeux(v));
	
	}

}
