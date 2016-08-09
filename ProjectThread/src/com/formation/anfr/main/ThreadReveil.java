package com.formation.anfr.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadReveil extends Thread {
	private boolean sortir;
	
	public ThreadReveil() {
		this.setName("Reveil");
		sortir=false;
	}
	
	@Override
	public void run() {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!sortir) {
				try {
					System.out.println("Appuyez pour réveiller");
					in.readLine();
					synchronized (this) {
											notify();
					}
					System.out.println("Debout la dedans!!!!");
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
