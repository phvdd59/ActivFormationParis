package com.formation.phva.main;

import java.util.Date;

public class MainPerso {

	public static void main(String[] args) {
		MainPerso m=new MainPerso();
		m.init();
	}

	private void init() {
		Perso perso=new Perso("NOM1", new Date(), new Date());
		
		perso.getDatePromo().setTime(new Date().getTime()-24*60*60*1000*10);
		
		System.out.println(perso);
	}

}
