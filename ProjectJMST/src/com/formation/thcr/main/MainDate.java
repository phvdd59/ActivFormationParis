package com.formation.thcr.main;

import java.sql.Date;
import java.sql.Timestamp;

public class MainDate {

	public static void main(String[] args) {
		MainDate main = new MainDate();
		main.init();
	}
	
	public void init(){
		java.util.Date dateUtil = new java.util.Date();
		Date date = new Date(dateUtil.getTime());
		System.out.println(date);
		Timestamp timestamp = new Timestamp(dateUtil.getTime());
		System.out.println(timestamp);
	}
	
}