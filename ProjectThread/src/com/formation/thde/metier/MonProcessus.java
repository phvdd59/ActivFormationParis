package com.formation.thde.metier;

import java.util.Date;

public class MonProcessus implements Runnable {

	public static int nb = 0;
	public int nbFois = 2000;

	@Override
	public void run() {
		System.out.println("Debut MonProcessus " + Thread.currentThread().getName());
		Date date1 = new Date();
		for (int i = 0; i < nbFois; i++) {
			Date date = new Date();
			if (Thread.currentThread().getName().equals("SecondThread")) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				}
				nb++;
				System.out.println(date.getTime() - date1.getTime() + "  " + Thread.currentThread().getName());
			} else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				nb++;
				System.out.println(date.getTime() - date1.getTime() + "  " + Thread.currentThread().getName());
			}
		}
		System.err.println("Fin MonProcessus" + Thread.currentThread().getName());
	}
}
