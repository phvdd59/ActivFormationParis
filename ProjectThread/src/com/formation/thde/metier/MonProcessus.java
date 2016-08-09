package com.formation.thde.metier;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		System.out.println("Bonjour MonProcessus" + Thread.currentThread().getName());
		System.out.println("Salut MonProcessus" + Thread.currentThread().getName());
	}
}
