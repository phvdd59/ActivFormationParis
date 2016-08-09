package com.formation.beba.main;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("Bonjour Main");
		MonProcessus monprocessus = new MonProcessus();
		Thread thread1 = new Thread(monprocessus, "PremierThread");

		Thread thread2 = new Thread(monprocessus, "SecondThread");
		thread1.start();
		thread2.start();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//		}
//		System.out.println("délai de 10sec");
		System.out.println("Au revoir Main");

	}
}
