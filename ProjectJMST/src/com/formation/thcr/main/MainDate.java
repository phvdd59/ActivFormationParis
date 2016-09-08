package com.formation.thcr.main;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.formation.beans.Perso;
import com.formation.thcr.metier.Personne;

public class MainDate {

	public static void main(String[] args) {
		MainDate main = new MainDate();
		main.init();
	}
	
	private void init2() {
Personne perso = new Personne();
perso.setMdp("lol");
System.out.println(perso.getMdp());
	}

	public void init(){
		
//		java.util.Date dateUtil = new java.util.Date();
//		Date date = new Date(dateUtil.getTime());
//		System.out.println(date);
//		Timestamp timestamp = new Timestamp(dateUtil.getTime());
//		System.out.println(timestamp);
//		ConversionPersonne conv = new ConversionPersonne();
//		System.out.println(conv.conversionSQLToUtil(date));
		
		Perso p = new Perso();
		p.setDateNaissance(new Date());
		Date date = p.getDateNaissance();
		System.out.println(date);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(formatter.format(date));
		String s = formatter.format(date); 
		try {
			date = formatter.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Personne pers = new Personne();
		
		pers.setDateNaissance(date);
		
		System.out.println(pers.getDateNaissance());
		
		
		
		
	}
	
}
