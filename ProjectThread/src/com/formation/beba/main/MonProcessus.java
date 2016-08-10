package com.formation.beba.main;

import java.util.Date;

public class MonProcessus implements Runnable {

	public int nb = 0;
	public int nbFois = 2000;

	@Override
	public void run() {
		System.out.println("Bonjour MonProcessus " + Thread.currentThread().getName());
		Date date = new Date();
		long d = date.getTime();
		if (Thread.currentThread().getName().equals("PremierThread")) {
			try {
				for (int i = 0; i < nbFois; i++) {
					date = new Date();
					long d2 = date.getTime();
					System.out.println(Thread.currentThread().getName() + " " + (d2 - d));
					Thread.sleep(10);
				}

			} catch (InterruptedException e) {
			}
			nb++;
			System.out.println("délai de 10sec");
		}
		if (Thread.currentThread().getName().equals("SecondThread")) {
			try {
				for (int i = 0; i < nbFois; i++) {
					date = new Date();
					long d2 = date.getTime();
					System.err.println(Thread.currentThread().getName() + " " + (d2 - d));
					Thread.sleep(20);
				}
				nb++;

			} catch (InterruptedException e) {
			}
			System.out.println("délai de 5sec");
		}
		System.err.println("Au revoir MonProcessus " + Thread.currentThread().getName());

	}

}
