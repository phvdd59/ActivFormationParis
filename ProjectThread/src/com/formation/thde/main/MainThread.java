package com.formation.thde.main;

import com.formation.thde.metier.MonProcessus;

public class MainThread {
	public static void main(String[] args) {

		System.out.println("Debut Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		thread1.start();
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread2.start();

//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//		}
//		System.out.println("10 sec");
		System.err.println("Fin Main");
	}
}
