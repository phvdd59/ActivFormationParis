package com.formation.thcr.main;

import com.formation.thde.exo.ExoSimple;

public class MainActiveFormationParis {

	public static void main(String[] args) {
		MainActiveFormationParis main = new MainActiveFormationParis();
		main.init();
	}

	private void init() {
		int[] tab = {1,2,8,0x7F_FF_FF_FF,7,-8,-2};
		int sum = new ExoSimple().sumTableau(tab);
		System.out.println(sum);
	}
}
