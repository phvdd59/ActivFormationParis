package com.formation.thde.metier;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		System.out.println("Debut MonProcessus " + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("SecondThread")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			System.out.println("5 sec");
		}else{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			System.out.println("10 sec");
		}
		System.err.println("Fin MonProcessus" + Thread.currentThread().getName());
	}
}
