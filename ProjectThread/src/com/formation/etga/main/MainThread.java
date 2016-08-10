package com.formation.etga.main;

import java.util.Date;

import com.formation.etga.metier.MonProcessus;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("Debut Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread1.start();
		thread2.start();

		Date d = new Date();
		long t = d.getTime();
		long t1 = t - t;
		
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println("Main" + " " + t1);
				Thread.sleep(500);
				Date d1 = new Date();
				t1 = d1.getTime() - t;

			} catch (InterruptedException e) {
			}
		}
		System.err.println("Fin Main");
	}
}
