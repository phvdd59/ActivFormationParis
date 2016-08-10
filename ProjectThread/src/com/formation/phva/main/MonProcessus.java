package com.formation.phva.main;

import java.util.Date;

public class MonProcessus implements Runnable {

	public static String nb = "";
	public int nbFois = 2000;

	public static void setNb(String s) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		nb += s;
		System.out.println(nb);
	}

	@Override
	public void run() {
		Date date = new Date();
		long lDebut = date.getTime();
		System.out.println("Debut MonProcessus " + Thread.currentThread().getName());
		//		if (Thread.currentThread().getName().equals("PremierThread")) {
		for (int i = 0; i < nbFois; i++) {
			//				try {
			//					Thread.sleep(10);
			//				} catch (InterruptedException e) {
			//				}
			for (int j = 0; j < 10000; j++) {
				setNb(new Integer(j + 5).toString());
			}
			//				Date d=new Date();
			//				long lEncours=d.getTime();
			//System.out.println("Premier ("+i+") "+(lEncours-lDebut));
		}
		//		}
		//		if (Thread.currentThread().getName().equals("SecondThread")) {
		for (int i = 0; i < nbFois; i++) {
			//				try {
			//					Thread.sleep(20);
			//				} catch (InterruptedException e) {
			//				}
			for (int j = 0; j < 10000; j++) {
				setNb(new Integer(j + 5).toString());
			}
			Date d = new Date();
			long lEncours = d.getTime();
			//System.out.println("Second ("+i+") "+(lEncours-lDebut));
		}
		//		}
		System.err.println("Fin MonProcessus " + Thread.currentThread().getName());
	}
}
