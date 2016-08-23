package com.formation.thde.ctr;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	private void init() {
		File exoTestXml = new File("C:/DevFormation/GITActivFormationParis/ProjectActivFormationParis/src/com/formation/thde/ctr/TestExo.xml");
		ListeMeuble lst = new ListeMeuble();
		lst.chargeXml(exoTestXml);
		System.out.println(lst);
	}
}
