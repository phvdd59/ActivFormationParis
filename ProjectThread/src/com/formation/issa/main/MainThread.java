package com.formation.issa.main;

import java.util.Date;

public class MainThread {

	public static void main(String[] args) {
		// Debug exploite le mécanisme de wait
		System.out.println("Bonjour Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");

		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread1.start();
		thread2.start();
		Date d=new Date();
		long t=d.getTime();
		
		try {
			for (int i = 0; i < 20; i++) {

				Thread.sleep(500);
				Date dateEnCours=new Date();
				long t1=dateEnCours.getTime();
				long duree=t1-t;
				System.out.println(Thread.currentThread().getName()+duree);
				//System.out.println("Thread");
				//Date à chaque élément i
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// try {
		//
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("délai de 10 secondes");
		System.out.println("Salut Main");

	}

}
