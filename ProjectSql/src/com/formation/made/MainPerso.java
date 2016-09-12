package com.formation.made;

import java.util.Date;

public class MainPerso {

	public static void main(String[] args) {
		MainPerso mainPerso=new MainPerso();
		mainPerso.init();

	}

	private static void init() {
		Perso perso=new Perso("nom1",new Date(),new Date());
		perso.getDatePromo().setTime(new Date().getTime()-24*60*60*1000*10);
		System.out.println(perso);
		
	}

}
