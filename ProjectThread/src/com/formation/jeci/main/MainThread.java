package com.formation.jeci.main;

import java.util.Date;

public class MainThread {
	public static void main(String[] args) {
		Date d0 = new Date();
		long t = d0.getTime();
		System.out.println("bonjour Main");
		System.out.println(t);

		MonProcessus monProcessus = new MonProcessus();
		Thread thread = new Thread(monProcessus, "PremierThread");

		thread.start();
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread2.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Salut Main");
	}
}
