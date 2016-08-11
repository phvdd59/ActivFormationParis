package com.formation.issa.main;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (!sortir) {
			System.out.println("appuyer pour réveiller");

			try {
				in.readLine();
				synchronized (this) {
					// Le notify réveille un wait et sort le thread d'un état de
					// blocage et on ne peut pas faire de wait et de notify en
					// même temps d'où le notify
					notify();
					// ThreadReveil va réveiller un thread mis en wait, et si
					// cascade il va prendre l'un d'eux.
				}
				System.out.println("Debout là-dedans!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
