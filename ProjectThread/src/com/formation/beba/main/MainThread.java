package com.formation.beba.main;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("Bonjour Main");
		MonProcessus monprocessus = new MonProcessus();
		Thread thread1 = new Thread(monprocessus, "PremierThread");

		Thread thread2 = new Thread(monprocessus, "SecondThread");
		thread1.start();
		thread2.start();
		for (int i = 0; i < 20; i++) {
			System.out.println("main");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// }
		// System.out.println("délai de 10sec");
		System.err.println("Au revoir Main");

	}
}
