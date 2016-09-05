package com.formation.thcr.main;

import java.sql.Date;
import java.sql.Timestamp;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.metier.Personne;

public class MainDate {

	public static void main(String[] args) {
		MainDate main = new MainDate();
		main.init();
	}
	
	public void init(){
		
		java.util.Date dateUtil = new java.util.Date();
		Date date = new Date(dateUtil.getTime());
//		System.out.println(date);
		Timestamp timestamp = new Timestamp(dateUtil.getTime());
//		System.out.println(timestamp);
		ConversionPersonne conv = new ConversionPersonne();
		System.out.println(conv.conversionSQLToUtil(date));
		
	}
	
}
