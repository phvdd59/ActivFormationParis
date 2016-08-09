package com.formation.joca.metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadReveil extends Thread {

	private boolean sortir;

	public void setSortir(boolean sortir) {
		this.sortir = sortir;
	}

	public ThreadReveil() {
		this.setName("REVEIL");
		sortir = false;
	}

	@Override
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		while (!sortir) {
			System.out.println("appuyer pour reveiller");
			try {
				in.readLine();
				synchronized (this) {
					notify();
				}
				System.out.println("Debout la dedans !");
			} catch (IOException e) {
			}
		}
	}

}
