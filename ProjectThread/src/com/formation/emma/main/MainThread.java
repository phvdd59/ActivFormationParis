package com.formation.emma.main;

public class MainThread {
	public static void main(String[] args) {

		System.out.println("bonjour main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread = new Thread(monProcessus, "PremierThread");
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread.start();
		thread2.start();

		System.out.println("fin main");

	}
}
