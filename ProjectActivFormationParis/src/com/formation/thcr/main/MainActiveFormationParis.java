package com.formation.thcr.main;

import com.formation.thde.exo.ExoSimple;

public class MainActiveFormationParis {

	public static void main(String[] args) {
		MainActiveFormationParis main = new MainActiveFormationParis();
		main.init();

	}

	private void init() {
		int[] tab = {1,2,8,6,7,-8,-2};
		System.out.println(new ExoSimple().sumTableau(tab));
		
	}

}
