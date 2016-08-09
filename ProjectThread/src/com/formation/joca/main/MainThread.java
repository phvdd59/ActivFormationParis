package com.formation.joca.main;

import java.util.Date;

import com.formation.joca.metier.MonProcessus;

public class MainThread {

	public static void main(String[] args) {

		System.out.println("bonjour main");
		MonProcessus monProcessus = new MonProcessus();
		Thread essai = new Thread(monProcessus, "PremierThread");
		Thread essai2 = new Thread(monProcessus, "DeuxiemeThread");
		essai.start();
		essai2.start();
		Date d = new Date();
		try {
			for (int i = 0; i < 20; i++) {
				Date temps = new Date();
				long resul = temps.getTime() - d.getTime();
				System.out.println(Thread.currentThread().getName() + " " + i + " " + resul);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ciao main");
	}

}
