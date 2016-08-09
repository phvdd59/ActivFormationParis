package com.formation.joca.metier;

import java.util.Date;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		Date d = new Date();
		System.out.println("bonjour monProcessus" + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("DeuxiemeThread")) {
			try {
				for (int i = 0; i < 20; i++) {
					Date temps = new Date();
					long resul = temps.getTime() - d.getTime();
					System.out.println(Thread.currentThread().getName() + " " + i + " " + resul);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (Thread.currentThread().getName().equals("PremierThread")) {
			try {
				for (int i = 0; i < 20; i++) {
					Date temps = new Date();
					long resul = temps.getTime() - d.getTime();
					System.out.println(Thread.currentThread().getName() + " " + i + " " + resul);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ciao monProcessus" + Thread.currentThread().getName());

	}

}
