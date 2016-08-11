package com.formation.emma.main;

import java.util.Date;

public class MainThread {

	public static void main(String[] args) {

		//System.out.println("bonjour main");
		MonProcessus monProcessus = new MonProcessus();
		Date date = new Date();
		long x = date.getTime();
		
		Thread thread = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread.start();
		thread2.start();

		//System.out.println("fin main");

		long y=0;
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
				Date date2 = new Date();
				y = date2.getTime();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long difference = y-x;
			System.out.print(Thread.currentThread().getName() + "," + difference + "\n");
		}

	}
}
