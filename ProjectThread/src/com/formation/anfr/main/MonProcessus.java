package com.formation.anfr.main;

import java.util.Date;

public class MonProcessus implements Runnable {
	public static int nb = 0;
	public int nbFois = 2000;

	@Override
	public void run() {
		Date dateProc = new Date();
		long dateLong = dateProc.getTime();
		// System.out.println("Debut " + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("PremierThread")) {
			for (int i = 0; i <nbFois; i++) {
				dateProc = new Date();
				System.out.println(Thread.currentThread().getName() + " : " + (dateProc.getTime() - dateLong));
				try {
					Thread.sleep(100);
					dateLong = dateProc.getTime();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nb++;
			}
		} else if (Thread.currentThread().getName().equals("SecondThread")) {
			for (int i = 0; i < nbFois; i++) {
				dateProc = new Date();
				System.out.println(Thread.currentThread().getName() + " : " + (dateProc.getTime() - dateLong));
				try {
					Thread.sleep(200);
					dateLong = dateProc.getTime();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nb++;
			}
		}
		System.out.println("Fin " + Thread.currentThread().getName());
	}

}
