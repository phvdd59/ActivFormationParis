package com.formation.made.main;

import com.formation.made.metier.ExoMade;

public class MainExoTest {

	public static void main(String[] args) {
		MainExoTest mainExoTest = new MainExoTest();
		mainExoTest.init();

	}

	private void init() {
		ExoMade exoMade = new ExoMade();
		String mdp = "Abc123456";
		exoMade.setMdpCache(mdp);
		System.out.println(exoMade.getMdp());
		exoMade.setCoordonnees("monadresse@fournisseur.com", "+336521202925");
		System.out.println(exoMade.getAdresseMail().equals("monadresse@fournisseur.com"));
		System.out.println(exoMade.getTel());
	}

}
