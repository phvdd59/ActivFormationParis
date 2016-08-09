package com.formation.beba.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadReveil extends Thread {

	private boolean sortir;

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
			System.out.println("appuyer pour réveiller !");
			try {
				in.readLine();
				synchronized (this) {

					notify();
				}
				System.out.println("Debout gros sac!!!!");
			} catch (IOException e) {
			}
		}
	}

	public boolean isSortir() {
		return sortir;
	}

	public void setSortir(boolean sortir) {
		this.sortir = sortir;
	}
}
