package com.formation.joca.main;

import com.formation.joca.metier.MonProcessus;

public class MainThread {

	public static void main(String[] args) {
		System.out.println("bonjour main");
		MonProcessus monProcessus = new MonProcessus();
		Thread essai = new Thread(monProcessus, "PremierThread");
		essai.start();
		try {
			essai.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread essai2 = new Thread(monProcessus, "DeuxiemeThread");
		essai2.start();
		System.out.println("salut main");
	}

}
