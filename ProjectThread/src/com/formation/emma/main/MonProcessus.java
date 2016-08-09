package com.formation.emma.main;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		System.out.println("bonjour processus" + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("SecondThread")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("5 sec ecoul�es");
		}

		
		if (Thread.currentThread().getName().equals("PremierThread")) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("10 sec ecoul�es");
		}

		System.out.println("fin processus" + Thread.currentThread().getName());

	}

}
