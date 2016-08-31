package com.formation.thcr.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;

public class ConversionPersonne {
	
	public Date conversionDate(String date){
		java.util.Date dateConvertiUtil = null;
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateConvertiUtil = formater.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dateSQL = new Date(dateConvertiUtil.getTime());
		return dateSQL;
	}
	
	public Timestamp conversionTimestamp (String date) {
		
		java.util.Date dateConvertiUtil = null;
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateConvertiUtil = formater.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp timestamp = new Timestamp(dateConvertiUtil.getTime());
		return timestamp;
	}

	public boolean conversionBoolean(String bool){
		boolean b = false;
		if(bool.equals("oui")){
			b = true;
		} else {
			b = false;
		}
		return b;
	}
	
}
