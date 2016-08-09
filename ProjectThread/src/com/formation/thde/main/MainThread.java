package com.formation.thde.main;

import java.util.Date;

import com.formation.thde.metier.MonProcessus;

public class MainThread {
	public static void main(String[] args) {

		System.out.println("Debut Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		thread1.start();
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread2.start();
//		Thread thread3 = new Thread(monProcessus, "TroisiemeThread");
//		thread3.start();
//		Thread thread4 = new Thread(monProcessus, "QuatriemeThread");
//		thread4.start();
		Date date1 = new Date();
		for (int i = 0; i < 20; i++) {
			Date date = new Date();
			try {
				System.out.println(date.getTime()-	date1.getTime() + "  Main");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//		try {
		//			Thread.sleep(10000);
		//		} catch (InterruptedException e) {
		//		}
		//		System.out.println("10 sec");
		System.err.println("Fin Main");
	}
}
