package com.formation.issa.main;

import com.formation.issa.exo.StringTravail;

public class MainStringTravail {
	

	public static void main(String[] args) {
		MainStringTravail mainStringTravail = new MainStringTravail();
		mainStringTravail.init();
		
	}

	private void init() {
		StringTravail exoString=new StringTravail();
		String mot="AbcDef";
		System.out.println(exoString.StringTravail(mot));
		
		
	}

}
