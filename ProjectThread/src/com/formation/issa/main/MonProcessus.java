package com.formation.issa.main;

import java.util.Date;

public class MonProcessus implements Runnable {
	
	public static int nb=0;
	public int nbFois=2000;

	@Override
	public void run() {
		//System.out.println("Bonjour mon processus" + Thread.currentThread().getName());
		Date dateIni=new Date();
		long tbis=dateIni.getTime();
		// if(Thread.currentThread().getName().equals("PremierThread")){
		// try {
		// Thread.sleep(5000);
		// System.out.println("délai de 5 secondes");
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		//
		// }
		// }
		//
		// if (Thread.currentThread().getName().equals("PremierThread")) {
		// try {
		// Thread.sleep(10000);
		//
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("délai de 10 secondes");
		// }
		//
		// if (Thread.currentThread().getName().equals("SecondThread")) {
		// try {
		// Thread.sleep(5000);
		//
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("délai de 5 secondes");
		// }
		// System.out.println("Salut, mon processus" +
		// Thread.currentThread().getName());

		if (Thread.currentThread().getName().equals("PremierThread")) {
			try {
				for (int i = 0; i < nbFois; i++) {
					Thread.sleep(10);
					Date dateEnCours1=new Date();
					long t1=dateEnCours1.getTime();
					long duree=t1-tbis;
					System.out.println(Thread.currentThread().getName()+duree);
					//System.out.println("PremierThread");

				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nb++;
		}
		if (Thread.currentThread().getName().equals("SecondThread")) {
			try {
				for (int i = 0; i < nbFois; i++) {
					Thread.sleep(20);
					Date dateEnCours2=new Date();
					long t2=dateEnCours2.getTime();
					long duree=t2-tbis;
					System.out.println(Thread.currentThread().getName()+duree);
					//System.out.println("SecondThread");

				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nb++;
		}

	}
}
