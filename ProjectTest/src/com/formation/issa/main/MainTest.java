package com.formation.issa.main;

import java.util.Date;

import com.formation.issa.metier.ExoIssa;

public class MainTest {

	public static void main(String[] args) {
		MainTest mainTest = new MainTest();
		mainTest.init();

	}

	private void init() {
		ExoIssa exoIssa = new ExoIssa();
		String adressMail = new String();
		String tel = new String();
		Date d = new Date();
		System.out.println(d);
		String mdpCache = new String();
		// char[] charArray = mdpCache.toCharArray();
		// char[] charArray1 = new char[charArray.length];
		// String mdp = new String(charArray1);
		mdpCache = "Acdef9";
		char[] charArray = mdpCache.toCharArray();
		exoIssa.setCoordonnee("dupont@outlook.fr", null);
		if (exoIssa.getAdressMail() == null) {
			System.out.println("null");
		} else {
			System.out.println(exoIssa.getAdressMail());

		}
		if (exoIssa.getTel() == null) {
			System.out.println("null");
		} else {
			System.out.println(exoIssa.getTel());
		}

	}

}
