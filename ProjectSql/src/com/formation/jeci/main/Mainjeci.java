package com.formation.jeci.main;

import java.util.Date;

public class Mainjeci {

	public static void main(String[] args) throws IllegalArgumentException, InterruptedException {
		Mainjeci m=new Mainjeci();
		m.init();

	}

	private void init() throws IllegalArgumentException, InterruptedException {
		Perso perso=new Perso("Nom1", new Date(), new Date());
		perso.getDatePromo().setTime(new Date().getTime()-24*60*60*1000*10);
		System.out.println(perso);
		
	}

}
