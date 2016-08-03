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
		//char[] charArray = mdpCache.toCharArray();
		//char[] charArray1 = new char[charArray.length];
		//String mdp = new String(charArray1);
		mdpCache = "Acdef9";
				char[] charArray = mdpCache.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		char[] charArray1 = new char[charArray.length];

		for (int j = 0; j < charArray.length; j++) {

			if (j == 0 || j % 2 == 0) {
				charArray1[j + 1] = charArray[j];
			} else {
				charArray1[j - 1] = charArray[j];
			}

		}
		System.out.println(charArray1);
		String mdp = new String(charArray1);
		System.out.println(mdp);

	}

	}

