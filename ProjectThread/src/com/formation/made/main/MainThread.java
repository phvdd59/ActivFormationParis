package com.formation.made.main;

import java.util.Date;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("Debut Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread1.start();
		thread2.start();
		Date datemaintenant = new Date();
		long ldatemaintenant = datemaintenant.getTime();
		for (int i = 0; i < 20; i++) {
			try {
				Date date = new Date();
				long l = date.getTime();
				Thread.sleep(500);
				long diff = l - ldatemaintenant;
				System.out.println(Thread.currentThread().getName() + " " + diff);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("Fin Main");
	}
}
