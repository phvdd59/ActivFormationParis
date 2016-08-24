package com.formation.issa.save;

import java.io.File;

public class MainListeMeuble {

	public static void main(String[] args) {
	MainListeMeuble mainListe=new MainListeMeuble();
	mainListe.init();

	}

	private void init() {
		ListeMeuble liste=new ListeMeuble();
		File fRep=null;
		File path=null;
		String files=null;
		liste.chargeListeMeuble(fRep);
		//liste.listeRepertoire(path, files);
		
	}

}
