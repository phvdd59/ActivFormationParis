package com.formation.ambr.ctrSave;

import java.io.File;

public class MainTxtFlux2 {

	public static void main(String[] args) {
		MainTxtFlux2 m = new MainTxtFlux2();
		m.init();
	}

	private void init() {
		ListeMeuble a = new ListeMeuble();
		File file = new File("./src/com/formation/ambr/ctr/ExempleXml.xml");
		a.chargeXml(file);
	}

}
