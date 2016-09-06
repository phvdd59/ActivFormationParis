package com.formation.thde.main;

import java.io.File;

import com.formation.thde.exo.ListeMeuble;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	private void init() {
		File exoTestXml = new File("C:/DevFormation/GITActivFormationParis/ProjectActivFormationParis/ikae");
		ListeMeuble lst = new ListeMeuble();
		lst.chargeListeMeuble(exoTestXml);
		System.out.println(lst);
	}
}
