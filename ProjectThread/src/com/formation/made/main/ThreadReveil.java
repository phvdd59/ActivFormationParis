package com.formation.made.main;

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
			System.out.println("appuyez pour reveiller");
			try {
				in.readLine();
				synchronized (this) {
					notify(); //va reveiller le 1er wait qu'il trouve pour le lever
				}
				
				System.out.println("Wake up !");
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
