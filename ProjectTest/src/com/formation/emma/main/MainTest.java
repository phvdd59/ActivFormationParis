package com.formation.emma.main;

import com.formation.emma.metier.ExoEmma;

public class MainTest {

	public static void main(String[] args) {
		String mot = "blablac";
		ExoEmma a = new ExoEmma();
		a.setMdpCache(mot);
		System.out.println(a.getMdp());;
a.setCoordonnee("adresse@gmail.com", "0611327171");


	}

}
