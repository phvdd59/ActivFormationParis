package com.formation.joca.metier;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		System.out.println("bonjour monProcessus" + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("DeuxiemeThread")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("delai de 5 secondes");
		} else if (Thread.currentThread().getName().equals("PremierThread")){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("delai de 10 secondes");
		}
		System.out.println("ciao monProcessus" + Thread.currentThread().getName());

	}

}
