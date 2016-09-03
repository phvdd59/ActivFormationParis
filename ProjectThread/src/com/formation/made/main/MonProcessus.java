package com.formation.made.main;

import java.util.Date;

public class MonProcessus implements Runnable {
	public static int nb=0;
	public int nbFois=2000;
	@Override
	public void run() {
		Date dateDepart = new Date();
		long ldatemaintenant = dateDepart.getTime();
		System.out.println("Debut MonProcessus " + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("PremierThread")) {
			for (int i = 0; i < nbFois; i++) {
				try {
					Thread.sleep(100);
					Date date = new Date();
					long l = date.getTime();
					long diff = l - ldatemaintenant;
					System.out.println(Thread.currentThread().getName() + " " + diff);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				nb++;
				// System.out.println("delai de 10 secondes ");
			}

		} else {
			for (int i = 0; i < nbFois; i++) {
				try {
					Thread.sleep(200);
					Date date = new Date();
					long l = date.getTime();
					long diff = l - ldatemaintenant;
					System.out.println(Thread.currentThread().getName()+" "+diff);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nb++;
			}
		}
		// System.err.println("Fin MonProcessus " + Thread.currentThread().getName());
	}

	// else{ la est la technique pour arreter un tread pendant le temps qu'on veut.
	// try {
	// Thread.sleep(5000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println("delai de 5 secondes");
	// }
	// System.err.println("Fin MonProcessus " + Thread.currentThread().getName());
	// }
}
