package com.formation.phva.main;

import java.util.Date;

public class MainThread {
	public static void main(String[] args) {
		Date date = new Date();
		long lDebut = date.getTime();
		System.out.println("Debut Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		Thread thread3 = new Thread(monProcessus, "SecondThread");
		try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
	}
		
		thread1.start();
		thread2.start();
		thread3.start();
//		for (int i = 0; i < 20; i++) {
////			try {
////				Thread.sleep(10);
////			} catch (InterruptedException e) {
////			}
//			for (int j = 0; j < 10000; j++) {
//				MonProcessus.nb+=new Integer(j+5).toString();
//			}
////			Date d = new Date();
////			long lEncours = d.getTime();
////			System.out.println("MAIN (" + i + ") " + (lEncours - lDebut));
//		}

		System.err.println("Fin Main");
	}
}
