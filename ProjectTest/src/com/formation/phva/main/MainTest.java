package com.formation.phva.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.frva.metier.ExoFrva;
import com.formation.phva.metier.GenericExo;

public class MainTest {

	public static void main(String[] args) {
		GenericExo<ExoFrva> gExoFra = new GenericExo<ExoFrva>();

		SimpleDateFormat fd = new SimpleDateFormat("yyyyddMM");
		Date dateEmbauche = new Date();
		dateEmbauche.setMonth(1);
		String add = "qsdfqsdf";
		add.contains("@");

		dateEmbauche.setTime(dateEmbauche.getTime() - 30 * 24 * 60 * 60 * 1000);
		String s = fd.format(new Date());
		Date date = new Date();
		System.out.println(s);
		ExoFrva e = new ExoFrva("Francoise");
		try {
			Date d = fd.parse("20151509");
			System.out.println(d);
			e.setDate(d);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
	}

}
