package com.formation.jeci.main;

import java.util.Date;

public class MonProcessus implements Runnable {
	public static int nbFois = 2000;
	public static int nb = 0;

	@Override
	public void run() {
		Date d0 = new Date();
		long t = d0.getTime();
		System.out.println("bonjour MonProcessus" + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("PremierThread")) {
			try {
				for (int i = 0; i < nbFois; i++) {
					System.out.println("bonjour MonProcessus" + Thread.currentThread().getName());
					Thread.sleep(100);
					Date d1 = new Date();
					long t1 = d1.getTime() - t;
					System.out.println(t1);
				}

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			nb++;

		} else if (Thread.currentThread().getName().equals("SecondThread")) {
			try {
				for (int i = 0; i < nbFois; i++) {
					System.out.println("coucou MonProcessus" + Thread.currentThread().getName());
					Thread.sleep(200);
					Date d1 = new Date();
					long t1 = d1.getTime() - t;
					System.out.println(t1);
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			nb++;

		}
		System.out.println("Salut MonProcessus" + Thread.currentThread().getName());
	}

}
