package com.formation.thde.metier;

import java.util.Date;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		System.out.println("Debut MonProcessus " + Thread.currentThread().getName());
		Date date1 = new Date();
		for (int i = 0; i < 20; i++) {
			Date date = new Date();
			if (Thread.currentThread().getName().equals("SecondThread")) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				System.out.println(date.getTime() - date1.getTime() + "  " + Thread.currentThread().getName());
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(date.getTime() - date1.getTime() + "  " + Thread.currentThread().getName());
			}
		}
		System.err.println("Fin MonProcessus" + Thread.currentThread().getName());
	}
}
