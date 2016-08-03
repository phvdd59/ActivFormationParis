package com.formation.ambr.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.ambr.metier.ExoAmbr;

public class MainTest {

	public static void main(String[] args) {

		MainTest mainTest = new MainTest();
		mainTest.init();

	}

	public void init() {

		ExoAmbr exoAmbr = new ExoAmbr();

		// setDate

		Date dateEmbauche = new Date(04 / 07 / 2016);
		//Date dateEmbauche2 = exoAmbr.setDate(dateEmbauche);
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		String s = fd.format(new Date());
		Date date = new Date();
		System.out.println(s);

		// try catch
		try {
			Date d = fd.parse("21-04-2016");
			System.out.println(d);
			exoAmbr.setDate(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// setMdp

		exoAmbr.setMdpCache("ASuleT5!");
		System.out.println(exoAmbr.getMdp());

	}

}
