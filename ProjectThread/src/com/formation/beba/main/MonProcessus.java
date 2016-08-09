package com.formation.beba.main;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		System.out.println("Bonjour MonProcessus " + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("PremierThread")) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			System.out.println("délai de 10sec");
		}
		if (Thread.currentThread().getName().equals("SecondThread")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			System.out.println("délai de 5sec");
		}
		System.out.println("Au revoir MonProcessus " + Thread.currentThread().getName());

	}

}
