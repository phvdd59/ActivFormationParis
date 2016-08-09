package com.formation.anfr.main;

import java.util.Date;

public class MainThread {
	public static void main(String[] args) {
		// System.out.println("Bonjour!");
		Date dateMain = new Date();
		long dateLong = dateMain.getTime();
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread1.start();
		thread2.start();
		for (int i = 0; i < 500; i++) {
			try {
				Thread.sleep(50);
				dateMain = new Date();
				System.out.println("Main : " + (dateMain.getTime() -dateLong));
				dateLong = dateMain.getTime();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MonProcessus.nb++;
		}

		System.out.println("Fin Main");
	}
}
