package com.formation.thde.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.thde.metier.ExoThde;

public class MainTest {

	public static void main(String[] args) {

		SimpleDateFormat fd = new SimpleDateFormat("ddMMyyyy");
		String s = fd.format(new Date());
		Date date = new Date();
		ExoThde e = new ExoThde("Truc");
		//		try {
		//			Date d = fd.parse("15091988");
		//			e.setDate(d);
		//		} catch (ParseException e) {
		//			e.printStackTrace();
		//		}

	}

}
