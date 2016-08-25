package com.formation.phva.dosFlux1.issa;

import java.io.File;

public class MainListeMeuble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainListeMeuble mainL=new MainListeMeuble();
		mainL.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ListeMeuble liste=new ListeMeuble();
		File file1=new File(".src/com/formation/issa/ctr/fFile.xml");
		liste.chargeXml(file1);
		
	}

}
