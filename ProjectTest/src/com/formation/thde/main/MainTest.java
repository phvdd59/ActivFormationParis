package com.formation.thde.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.thde.metier.ExoThde;

public class MainTest {

	public static void main(String[] args) {

		MainTest mainTest = new MainTest();
		mainTest.init();
	}

	public void init() {

		ExoThde exo = new ExoThde("pouette");
		exo.setMdpCache("abC1");
		System.out.println(exo.getMdp());

		exo.setCoordonnees("doodeedoo@gmail.com", "+5420a000000");
		System.out.println(exo.getAdresseMail());
		System.out.println(exo.getTel());

		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = fd.parse("01-01-2030");
			exo.setDate(d);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println(exo.getDateEmbauche());
	}
}
