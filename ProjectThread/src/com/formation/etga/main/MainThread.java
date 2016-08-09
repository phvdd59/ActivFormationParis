package com.formation.etga.main;

import com.formation.etga.metier.MonProcessus;

public class MainThread {
	public static void main(String[] args) {
		
		System.out.println("Bonjour Main");
		MonProcessus monProcessus = new MonProcessus();
		Thread thread1 = new Thread(monProcessus, "PremierThread");
		thread1.start();
		Thread thread2 = new Thread(monProcessus, "SecondThread");
		thread2.start();
		System.out.println("Salut Main");
	}
}
