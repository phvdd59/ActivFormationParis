package com.formation.etga.metier;

import java.util.Date;

public class MonProcessus implements Runnable {

	public static int nb=0;
	public int nbFois = 2000;
	
	@Override
	public void run() {

		// Delai pour les Threads		

		//		System.out.println("Debut MonProcessus" + Thread.currentThread().getName());
		//		if (Thread.currentThread().getName().equals("SecondThread")) {
		//			try {
		//				Thread.sleep(5000);
		//			} catch (InterruptedException e) {
		//			}
		//			System.out.println("delais de 5 secondes");
		//		}
		//		if (Thread.currentThread().getName().equals("PremierThread")) {
		//			try {
		//				Thread.sleep(10000);
		//			} catch (InterruptedException e) {
		//			}
		//			System.out.println("delais de 10 secondes");
		//		}
		//		System.err.println("Fin MonProcessus" + Thread.currentThread().getName());

		// Affichage de message tous les ...	

		Date d2 = new Date();
		long t2 = d2.getTime();
		long t3 = t2 - t2;
		
		System.out.println("Debut MonProcessus" + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("PremierThread")) {
			for (int i = 0; i < 20; i++) {
				try {
					System.out.println("Thread1"  + " " + t3);
					Thread.sleep(1000);
					Date d3 = new Date();
					t3 = d3.getTime() - t2;
				} catch (InterruptedException e) {
				}
			}
		}
		if (Thread.currentThread().getName().equals("SecondThread")) {
			for (int i = 0; i < 20; i++) {
				try {
					System.out.println("Thread2"+ " " + t3);
					Thread.sleep(2000);
					Date d3 = new Date();
					t3 = d3.getTime() - t2;
				} catch (InterruptedException e) {
				}
			}
		}
		System.err.println("Fin MonProcessus" + Thread.currentThread().getName());
	}
}
