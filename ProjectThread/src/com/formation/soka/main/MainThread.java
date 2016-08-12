package com.formation.soka.main;

import java.text.DecimalFormat;
import java.util.Date;

import com.formation.soka.metier.MonProcessus;

public class MainThread {

	public static void main(String[] args) {
		System.out.println("Début Main");
		Date dateDebut = new Date();
		long t = System.nanoTime();
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread1.start();
		thread2.start();
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Date date = new Date();
			long temps = date.getTime()-dateDebut.getTime();
			System.out.println(Thread.currentThread().getName() + " " + difToString(t, System.nanoTime())+" Date : "+ temps);

		}
		System.out.println("Fin Main");
	}

	public static String difToString(long t, long nanoTime) {
		double dif = ((double) nanoTime - t) / 1000000;
		DecimalFormat df = new DecimalFormat("####");
		return df.format(dif) + " ms";
	}
}