package com.formation.made.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		exoMade.setCoordonnees("@.com", "+33365212090");
		System.out.println(exoMade.getAdresseMail());
		System.out.println(exoMade.getTel());

		Pattern pattern = Pattern.compile("\\d");
		Pattern pattern2 = Pattern.compile("\\W");
		Matcher matcher = pattern2.matcher("aaaaaaaaa");
		System.out.println(matcher.find());
	}

}
